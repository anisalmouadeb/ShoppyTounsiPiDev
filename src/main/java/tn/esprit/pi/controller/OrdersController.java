package tn.esprit.pi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.repository.OrdersRepository;
import tn.esprit.pi.repository.ShoppingCartRepository;
import tn.esprit.pi.service.IOrdersService;

@RestController
public class OrdersController {

	@Autowired
	OrdersRepository OrdersRepo;
	@Autowired
	ShoppingCartRepository ShoppingCartRepo;

	@Autowired
	IOrdersService OrdersService;

	@RequestMapping(value = "/ConfirmOrder/{ShoppingCartId}", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ")
	public String ConfirmOrder(@PathVariable("ShoppingCartId") long ShoppingCartId) {
		return OrdersService.ConfirmOrder(ShoppingCartId);
	}
	/*
	 * @RequestMapping(value = "/InsertOrderLineToOrder/{orderLineId}", method =
	 * RequestMethod.POST)
	 * 
	 * @PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ") public String
	 * InsertOrderLineToOrder(@PathVariable("orderLineId") long orderLineId) {
	 * return OrdersService.InsertOrderLineToOrder(orderLineId); }
	 */
}
