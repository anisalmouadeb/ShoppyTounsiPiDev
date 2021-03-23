package tn.esprit.pi.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import tn.esprit.pi.entities.User;

public interface IUserService {

	public User getUserById(long userId);

	public List<User> getAllUsers();

	public String deleteUserById(long userId);



	public User updateUser(User u, Authentication auth);

}
