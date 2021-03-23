package tn.esprit.pi.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.payload.JwtResponse;
import tn.esprit.pi.payload.MessageResponse;
import tn.esprit.pi.repository.UserRepository;
import tn.esprit.pi.security.JwtUtils;
import tn.esprit.pi.security.UserDetailsImpl;
import tn.esprit.pi.service.IUserService;

@RestController
public class UserRestControllerImpl {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	IUserService iUserService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("/getAllUsers")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public List<User> getAllUsers() {

		return iUserService.getAllUsers();
	}

	@DeleteMapping("/deleteUserById/{iduser}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public String deleteEntryById(@PathVariable("iduser") long userId) {
		
		

		return iUserService.deleteUserById(userId);

	}

	@PutMapping(value = "/updateUser")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestBody User u, Authentication auth) {
		User u1 = userRepository.findByName(auth.getName()).get();
		if (!u.getName().equals(u1.getName())) {
			if (userRepository.existsByName(u.getName())) {
				return ResponseEntity.badRequest().body(
						new MessageResponse("Error: Username is already taken!" + u1.getName() + "" + u1.getEmail()));
			}
		}

		if (!u.getEmail().equals(u1.getEmail())) {
			if (userRepository.existsByEmail(u.getEmail())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
			}
		}
		System.out.println(u.getPassword());
		User user = iUserService.updateUser(u, auth);

		System.out.println(user.getPassword());
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), u.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));

	
	}

}
