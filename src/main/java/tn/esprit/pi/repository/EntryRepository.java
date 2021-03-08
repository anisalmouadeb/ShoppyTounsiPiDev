package tn.esprit.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Entry;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long>{

	
	@Query("Select e from Entry e "
			+ "join e.product p "
			+ "where p.productId=:productId") 
	public List<Entry> getEntryByProduct(@Param("productId")long productId);
	
	@Query("Select e from Entry e "
			+ "join e.provider p "
			+ "where p.providerId=:providerId") 
	public List<Entry> getEntryByProvider(@Param("providerId")long providerId);
	
	@Query("Select count(*)from Entry e "
			+ "join e.provider p "
			+ "where p.providerId=:providerId") 
	public int NbEntryProvider(@Param("providerId")long providerId);
	
	
}
