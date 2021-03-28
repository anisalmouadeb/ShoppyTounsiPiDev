package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.ShoppingCart;
import tn.esprit.pi.repository.OrderLineRepository;
import tn.esprit.pi.repository.ProductRepository;
import tn.esprit.pi.repository.ShoppingCartRepository;
import tn.esprit.pi.repository.UserRepository;
import tn.esprit.pi.service.IOrderLineService;
import tn.esprit.pi.service.IShoppingCartService;
import tn.esprit.pi.service.ProductService;

@RestController

public class ShoppingCartControllerImpl {
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

	@Autowired
	IOrderLineService OrderLineService;

	@RequestMapping(value = "/AddOrderLinesToShoppingCart/{ShoppingCartId}/{OL}", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ")
	public String AddOrderLinesToShoppingCart(@PathVariable("ShoppingCartId") Long ShoppingCartId,
			@PathVariable("OL") Long OL) {
		return ShoppingCartService.AddOrderLinesToShoppingCart(ShoppingCartId, OL);
	}
	
	@GetMapping(value = "/getAllOrderLinesByShoppingCart/{ShoppingCartId}")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ")
	@ResponseBody
	public List<OrderLine> getAllOrderLinesByShoppingCart(@PathVariable("ShoppingCartId") Long ShoppingCartId) {
		return ShoppingCartService.getAllOrderLinesByShoppingCart(ShoppingCartId);
	}
	
	
	@GetMapping(value = "getShoppingCartProducts/{ShoppingCartId}")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
	@ResponseBody
	public List<String> getShoppingCartProducts(@PathVariable("ShoppingCartId") Long ShoppingCartId) {
		return ShoppingCartService.getShoppingCartProducts(ShoppingCartId);
	}
	
	@GetMapping(value = "getTotalAmount/{ShoppingCartId}")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
	@ResponseBody
	public float getTotalAmount(@PathVariable("ShoppingCartId") Long ShoppingCartId) {
		return ShoppingCartService.getTotalAmount(ShoppingCartId);
	}
	

}
