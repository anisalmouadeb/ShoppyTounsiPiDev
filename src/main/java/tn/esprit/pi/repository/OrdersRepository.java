package tn.esprit.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{
	
	
	@Query(value = "SELECT * FROM orderLine o WHERE o.confirmed = 1", nativeQuery = true)
	public List<OrderLine> ConfirmedOrderLinesByOrder(Long OrderId);

}
