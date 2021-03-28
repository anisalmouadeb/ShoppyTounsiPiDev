package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Orders;
import tn.esprit.pi.entities.ShoppingCart;

public interface IOrdersService {

	public String ConfirmOrder(long ShoppingCartId);

	public Orders InsertOrderLineToOrder(List<OrderLine> orderLine, Orders ord);

	// public String PaymentDone(Orders Order);

	public String PaymentDone(long OrderId);

	public String PaymentDone(long OrderId, String code);

}
