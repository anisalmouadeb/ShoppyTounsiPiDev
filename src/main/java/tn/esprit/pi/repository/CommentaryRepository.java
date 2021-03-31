package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.pi.entities.Commentary;

public interface CommentaryRepository extends CrudRepository<Commentary, Long> {

}
