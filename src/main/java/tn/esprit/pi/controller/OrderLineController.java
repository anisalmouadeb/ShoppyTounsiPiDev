package tn.esprit.pi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShoppingCart;
import tn.esprit.pi.repository.OrderLineRepository;
import tn.esprit.pi.repository.ProductRepository;
import tn.esprit.pi.repository.ShoppingCartRepository;
import tn.esprit.pi.repository.UserRepository;
import tn.esprit.pi.service.IOrderLineService;
import tn.esprit.pi.service.IShoppingCartService;
import tn.esprit.pi.service.ProductService;

@RestController
public class OrderLineController {
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

	@PostMapping("/addOrderLine")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ")
	@ResponseBody
	public ResponseEntity<String> AddOrderLineByProductId(@RequestBody OrderLine orderLine) {
		ShoppingCart s = ShoppingCartRepo.findById(orderLine.getShoppingCart().getShoppingCartId()).get();
		Product pro = ProductRepo.findById(orderLine.getProduct().getProductId()).get();

		if (orderLine.getQuantity() > pro.getQuantity()) {
			return ResponseEntity.badRequest().body("unvailable quantity");

		}

		OrderLineService.AddOrderLineByProductId(orderLine);
		return ResponseEntity.ok("OrderLine added");

	}

	@DeleteMapping("/DeleteOrderLine/{idOL}")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ")
	@ResponseBody
	public String DeleteOrderLine(@PathVariable("idOL") long orderLineId) {
		return OrderLineService.DeleteOrderLine(orderLineId);

	}

}
