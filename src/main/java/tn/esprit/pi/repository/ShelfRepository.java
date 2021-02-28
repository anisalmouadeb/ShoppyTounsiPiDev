package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Shelf;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf,Long> {

}
