package tn.esprit.pi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

	
	
	
	@Query("select DISTINCT s from ShoppingCart s "
             + "where s.id=:ShoppingCartId")
	 public List<ShoppingCart> getAllOrderLinesByShoppingCart(@Param("ShoppingCartId")Long ShoppingCartId);

	//List<ShoppingCart> getShoppingCartById(long shoppingCart);


}
