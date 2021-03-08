package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.pi.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
