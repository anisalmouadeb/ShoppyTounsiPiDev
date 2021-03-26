package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.OrderLine;

public interface IOrderLineService {

	public String AddOrderLineByProductId(OrderLine orderLine);

	public List<OrderLine> getOrderLineByShoppingCartId(long ShoppingCartId);

	public List<OrderLine> removeOrderLineByShoppingCartId(long orderLineId, long ShoppingCartId);

	public void updateQtyByOrderLineId(long orderLineId, int quantity, float price);

	public String DeleteOrderLine(long OrderLine);

}
