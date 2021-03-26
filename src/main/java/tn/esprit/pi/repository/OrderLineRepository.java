package tn.esprit.pi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.OrderLine;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {

	

	/*List<OrderLine> getOrderLineByShoppingCartId(long shoppingCartId);

	void updateQtyByOrderLineId(long orderLineId, int quantity, float price);

	void removeOrderLineByShoppingCartId(long orderLineId, long shoppingCartId);*/
	

}
