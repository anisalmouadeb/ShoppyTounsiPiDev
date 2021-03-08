package tn.esprit.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query("Select " + "DISTINCT prod from Product prod " + "where prod.quantity < 10")
	public List<Product> listMissingProduct();

	Product findByName(String name);
	
	
	

}
