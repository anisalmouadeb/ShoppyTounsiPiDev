package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.DeliveryMan;
@Repository
public interface DeliveryManRepository extends CrudRepository<DeliveryMan, Long> {

}
