package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.OrderLine;

public interface IOrderLineService {

	public String AddOrderLineByProductId(OrderLine orderLine);

	public String DeleteOrderLine(long OrderLine);

}
