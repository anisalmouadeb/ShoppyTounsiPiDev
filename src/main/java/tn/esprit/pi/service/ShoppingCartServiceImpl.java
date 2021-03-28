package tn.esprit.pi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ShoppingCartServiceImpl implements IShoppingCartService {

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

	@Override
	public ShoppingCart getShoppingCartById(long ShoppingCartId) {

		return this.ShoppingCartRepo.findById(ShoppingCartId).get();
	}

	@Override
	public String AddOrderLinesToShoppingCart(Long ShoppingCartId, Long OL) {

		ShoppingCart s = ShoppingCartRepo.findById(ShoppingCartId).get();
		OrderLine o = OrderLineRepo.findById(OL).get();
		if (s == null) {
			s = new ShoppingCart();
		} else {
			if (s.getOrderLines() == null) {
				List<OrderLine> orderLines = new ArrayList<>();
				orderLines.add(o);
				s.setOrderLines(orderLines);
				o.setShoppingCart(s);
			} else {
				s.getOrderLines().add(o);
				o.setShoppingCart(s);
			}
		}
		o.setConfirmed(false);
		ShoppingCartRepo.save(s);
		OrderLineRepo.save(o);
		return "Added OrderLines To Cart";
	}

	@Override
	public List<OrderLine> getAllOrderLinesByShoppingCart(long ShoppingCartId) {
		ShoppingCart s = ShoppingCartRepo.findById(ShoppingCartId).get();
		return s.getOrderLines();
	}

	@Override
	public List<String> getShoppingCartProducts(long ShoppingCartId) {
		ShoppingCart s = ShoppingCartRepo.findById(ShoppingCartId).get();

		List<String> pnames = new ArrayList<>();

		for (OrderLine ol : s.getOrderLines()) {
			pnames.add(ol.getProduct().getName());
		}

		return pnames;

	}

	@Override
	public float getTotalAmount(long ShoppingCartId) {
		ShoppingCart s = ShoppingCartRepo.findById(ShoppingCartId).get();
		float totalAmount=0;
		
		for (OrderLine ol : s.getOrderLines()) {
			totalAmount = totalAmount+ol.getPrice();
		}

		return totalAmount;

	}
}
