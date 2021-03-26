package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.ShoppingCart;

public interface IShoppingCartService {

	public ShoppingCart getShoppingCartById(long ShoppingCartId);

	// public String AddOrderLinesToShoppingCart(Long ShoppingCartId);

	public String AddOrderLinesToShoppingCart(Long ShoppingCartId, Long OL);

	// public ShoppingCart getAllOrderLinesByShoppingCart(Long ShoppingCartId);



	public List<OrderLine> getAllOrderLinesByShoppingCart(long ShoppingCartId);

	public List<String> getShoppingCartProducts(long ShoppingCartId);



}
