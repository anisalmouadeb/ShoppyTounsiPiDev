package tn.esprit.pi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Category;
import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShoppingCart;
import tn.esprit.pi.repository.OrderLineRepository;
import tn.esprit.pi.repository.ProductRepository;
import tn.esprit.pi.repository.ShoppingCartRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
public class OrderLineServiceImpl implements IOrderLineService {

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
	ShoppingCartRepository ShoppingCartRepo;

	@Override
	public String AddOrderLineByProductId(OrderLine orderLine) {

		Product pro = ProductRepo.findById(orderLine.getProduct().getProductId()).get();
		ShoppingCart s = ShoppingCartRepo.findById(orderLine.getShoppingCart().getShoppingCartId()).get();
		List<Product> products = new ArrayList<Product>();
		List<OrderLine> orders = new ArrayList<OrderLine>();
		orders = s.getOrderLines();
		for (OrderLine o : orders) {
			if (o.getProduct() == pro) {
				o.setQuantity(o.getQuantity() + orderLine.getQuantity());
				pro.setQuantity(pro.getQuantity() - orderLine.getQuantity());
				o.setPrice(pro.getPriceV() * o.getQuantity());
				o.setConfirmed(false);
				ProductRepo.save(pro);
				OrderLineRepo.save(o);
				return "updated quantity";
			}
		}

		orderLine.setPrice(pro.getPriceV() * orderLine.getQuantity());
		orderLine.setConfirmed(false);
		pro.setQuantity(pro.getQuantity() - orderLine.getQuantity());
		ProductRepo.save(pro);
		OrderLineRepo.save(orderLine);
		return "added";

	}

	@Override
	public String DeleteOrderLine(long OrderLine) {

		OrderLine o = OrderLineRepo.findById(OrderLine).get();
		Product pro = ProductRepo.findById(o.getProduct().getProductId()).get();
		pro.setQuantity(pro.getQuantity() + o.getQuantity());
		ProductRepo.save(pro);
		OrderLineRepo.delete(o);
		return "DeletedOrderLine";
	}

	
	

}
