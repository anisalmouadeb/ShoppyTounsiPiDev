package tn.esprit.pi.service;

import java.io.FileNotFoundException;
import java.util.List;
import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Orders;
import tn.esprit.pi.entities.ShoppingCart;
import tn.esprit.pi.entities.User;

public interface IOrdersService {

	public String ConfirmOrder(long ShoppingCartId);

	public Orders InsertOrderLineToOrder(List<OrderLine> orderLine, Orders ord);

	// public String PaymentDone(Orders Order);

	// public String PaymentDone(long OrderId);

	public String PaymentDone(long OrderId, String code);

	public List<OrderLine> ConfirmedOrderLinesByOrder(Long OrderId);

	public Orders getOrderById(Long id);

	public Orders GetOrderOftheMonth();

	
	public User GetStarUserOftheMonth();



}
