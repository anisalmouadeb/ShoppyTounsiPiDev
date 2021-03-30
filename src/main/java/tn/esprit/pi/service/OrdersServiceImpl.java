package tn.esprit.pi.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import tn.esprit.pi.configuration.EmailConfig;
import tn.esprit.pi.entities.BonAchat;
import tn.esprit.pi.entities.MailHistory;
import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Orders;
import tn.esprit.pi.entities.ShoppingCart;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.BonAchatRepository;
import tn.esprit.pi.repository.OrderLineRepository;
import tn.esprit.pi.repository.OrdersRepository;
import tn.esprit.pi.repository.ProductRepository;
import tn.esprit.pi.repository.ShoppingCartRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
public class OrdersServiceImpl implements IOrdersService {
	private EmailConfig emailCfg;

    public OrdersServiceImpl(EmailConfig emailCfg) {
        this.emailCfg = emailCfg;
    }
	
	@Autowired
	ShoppingCartRepository ShoppingCartRepo;
	@Autowired
	OrderLineRepository OrderLineRepo;
	@Autowired
	ProductRepository ProductRepo;
	@Autowired
	ProductService proService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	IShoppingCartService ShoppingCartService;
	@Autowired
	IOrderLineService OrderLineService;
	@Autowired
	OrdersRepository OrdersRepo;
	@Autowired
	BonAchatRepository BonAchatRepo;

	@Override
	public String ConfirmOrder(long ShoppingCartId) {

		Date date = new Date();

		ShoppingCart s = ShoppingCartRepo.findById(ShoppingCartId).get();
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		orderLines = s.getOrderLines();
		for (OrderLine o : orderLines) {
			System.out.println(o.getOrderLineId());
		}
		List<OrderLine> orderLines2 = new ArrayList<OrderLine>();
		Orders order = new Orders();
		order.setOrderLine(orderLines2);
		float totalAmount = 0;
		for (OrderLine o : orderLines) {
			if (o.getConfirmed() == false) {
				order.getOrderLine().add(o);
				o.setConfirmed(true);

				totalAmount = totalAmount + o.getPrice();
				OrderLineRepo.save(o);
			}
		}
		order.setOrderDate(date);
		order.setOrderAmount(totalAmount);
		OrdersRepo.save(order);
		return "Saved Orders";

	}

	@Override
	public Orders InsertOrderLineToOrder(List<OrderLine> orderLine, Orders ord) {

		for (OrderLine o : orderLine) {
			System.out.println(o.getOrderLineId());
			ord.getOrderLine().add(o);
		}
		return ord;
	}

	@Override
	public String PaymentDone(long OrderId, String code) {
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		Orders o = OrdersRepo.findById(OrderId).get();
		User u = new User();
		orderLines = o.getOrderLine();
		float totalAmountOrder = 0;
		for (OrderLine ol : orderLines) {
			totalAmountOrder = totalAmountOrder + ol.getPrice();
			u = ol.getShoppingCart().getUser();

		}
		float Totalpts = u.getPoint() * 100;
		BonAchat bAchat = BonAchatRepo.findByCode(code);
		float BaPrice = bAchat.getPrice();
		System.out.println(Totalpts + BaPrice);
		System.out.println(totalAmountOrder);
		if (totalAmountOrder < Totalpts + BaPrice) {
			return "payment done with success ";
		} else {
			return "update BA or points ";
		}

	}

	@Override
	public Orders getOrderById(Long id) {
		return OrdersRepo.findById(id).get();
	}

	@Override
	public List<OrderLine> ConfirmedOrderLinesByOrder(Long OrderId) {
		return OrdersRepo.ConfirmedOrderLinesByOrder(OrderId);

	}

	@Override
	public Orders GetOrderOftheMonth() {
		Date date = new Date();
		int month = date.getMonth();
		List<Orders> lastMorders = new ArrayList<>();
		List<Orders> orders = (List<Orders>) OrdersRepo.findAll();
		for (Orders os : orders) {
			if (os.getOrderDate().getMonth() == month) {
				lastMorders.add(os);
				System.out.println(lastMorders.size());
			}
		}
		Orders MaxAmount = lastMorders.get(0);

		for (Orders Ords : lastMorders) {
			if (MaxAmount.getOrderAmount() < Ords.getOrderAmount())
				MaxAmount = Ords;
		}
		return MaxAmount;
	}

	@Override
	public User GetStarUserOftheMonth() {
		Date date = new Date();
		int month = date.getMonth();
		List<Orders> lastMorders = new ArrayList<>();
		List<Orders> orders = (List<Orders>) OrdersRepo.findAll();
		for (Orders os : orders) {
			if (os.getOrderDate().getMonth() == month) {
				lastMorders.add(os);
				System.out.println(lastMorders.size());
			}
		}
		Orders MaxAmount = lastMorders.get(0);

		for (Orders Ords : lastMorders) {
			if (MaxAmount.getOrderAmount() < Ords.getOrderAmount())
				MaxAmount = Ords;
		}

		User u = new User();
		for (OrderLine o : MaxAmount.getOrderLine()) {
			u = o.getShoppingCart().getUser();
		}
		u.setPoint(u.getPoint() + 20);
		userRepo.save(u);
		return u;
	}

	@Override
	public String CancelOrder(long OrderId) {
		Date d = new Date();
		Date expiration = new Date(d.getTime() - (1 * 86400000));
		Orders o = OrdersRepo.findById(OrderId).get();
		if (o.getOrderDate().compareTo(expiration) >0&& o.getConfirmedPayment()==true) {
			o.setConfirmedPayment(false);
			User u = new User();
			for (OrderLine o1 : o.getOrderLine()) {
				System.out.println(o1.getShoppingCart().getShoppingCartId());
				u = o1.getShoppingCart().getUser();
				System.out.println(u.getName());
				
			}
			u.setPoint((int) (u.getPoint() + (o.getOrderAmount() / 10)));

			userRepo.save(u);
			
			
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost(this.emailCfg.getHost());
			mailSender.setPort(this.emailCfg.getPort());
			mailSender.setUsername(this.emailCfg.getUsername());
			mailSender.setPassword(this.emailCfg.getPassword());
			// Create an email instance
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("ShoppyTounsi@Gmail.com");
			mailMessage.setTo(u.getEmail());
			mailMessage.setSubject("you  order was canceled  ");
			mailMessage.setText("you have received as refund some points "+o.getOrderAmount() / 10);
			// Send mail
			mailSender.send(mailMessage);	
	

	return "cancel order";
		}
		return "can't cancel order";
	}
}
