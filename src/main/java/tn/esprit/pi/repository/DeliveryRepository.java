package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Delivery;
@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

}
