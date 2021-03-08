package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
