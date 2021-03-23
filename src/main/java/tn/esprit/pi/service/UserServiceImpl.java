package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.ShelfRating;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.ShelfRatingRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ShelfRatingRepository shelfRatingRepository;
	@Autowired
	ShelfServiceImpl shelfServiceImpl;

	@Override
	public User getUserById(long userId) {

		return userRepository.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {

		return (List<User>) userRepository.findAll();
	}

	@Override
	public String deleteUserById(long userId) {
		User u = userRepository.findById(userId).get();

		List<ShelfRating> s = (List<ShelfRating>) shelfRatingRepository.findAll();

		for (ShelfRating s1 : s) {
			if (s1.getUser() == u) {
				shelfServiceImpl.deleteRating(s1.getRatingId());
			}
		}
		userRepository.deleteRole(u.getUserId());
		userRepository.delete(u);
		return "deleted";
	}

	@Override
	public User updateUser(User u, Authentication auth) {
		User u1 = userRepository.findByName(auth.getName()).get();
		if (!u.getAddress().equals(""))
			u1.setAddress(u.getAddress());
		if (u.getAge() != 0)
			u1.setAge(u.getAge());
		if (!u.getEmail().equals(""))
			u1.setEmail(u.getEmail());
		if (!u.getName().equals(""))
			u1.setName(u.getName());
		if (!u.getNumTel().equals(""))
			u1.setNumTel(u.getNumTel());
		if (!u.getPassword().equals(""))
			u1.setPassword(encoder.encode(u.getPassword()));

		userRepository.save(u1);
		return u1;

	}

}
