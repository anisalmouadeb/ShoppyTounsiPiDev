package tn.esprit.pi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Orders;
import tn.esprit.pi.entities.ShoppingCart;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.OrderLineRepository;
import tn.esprit.pi.repository.OrdersRepository;
import tn.esprit.pi.repository.ProductRepository;
import tn.esprit.pi.repository.ShoppingCartRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
public class OrdersServiceImpl implements IOrdersService {

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

	@Override
	public String ConfirmOrder(long ShoppingCartId) {

		ShoppingCart s = ShoppingCartRepo.findById(ShoppingCartId).get();
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		orderLines = s.getOrderLines();
		for (OrderLine o : orderLines) {
			System.out.println(o.getOrderLineId());
		}
		List<OrderLine> orderLines2 = new ArrayList<OrderLine>();
		Orders order = new Orders();
		order.setOrderLine(orderLines2);
		for (OrderLine o : orderLines) {
			if (o.getConfirmed() == false) {
				order.getOrderLine().add(o);
				o.setConfirmed(true);
				OrderLineRepo.save(o);
			}
		}
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
			u=ol.getShoppingCart().getUser();
			
		}

		return " payment done";

	}

	@Override
	public String PaymentDone(long OrderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
