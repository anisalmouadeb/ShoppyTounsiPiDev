package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {

}
