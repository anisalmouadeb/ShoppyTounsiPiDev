package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.BonAchat;

@Repository
public interface BonAchatRepository extends CrudRepository<BonAchat, Long>{

	public BonAchat findByCode(String code);
	

}
