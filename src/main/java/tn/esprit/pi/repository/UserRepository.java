package tn.esprit.pi.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.pi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByName(String name);
	
	public Optional<User> findByEmail(String email);

	Boolean existsByName(String name);

	Boolean existsByEmail(String email);

	public Optional<User> findByResetToken(String token);
	
	
	
	@Modifying
	@Transactional
	@Query(value="delete from user_roles where user_roles.user_id=:id ", nativeQuery =true)
	public int deleteRole(@Param("id")long id);
	
	

}
