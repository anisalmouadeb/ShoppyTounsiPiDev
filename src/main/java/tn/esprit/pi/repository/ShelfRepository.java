package tn.esprit.pi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShelfType;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf,Long> {

	
    List<Shelf> findAllByType(ShelfType type);

	@Query("SELECT count(*) FROM Shelf")
    public int countshelf();
	
	
}
