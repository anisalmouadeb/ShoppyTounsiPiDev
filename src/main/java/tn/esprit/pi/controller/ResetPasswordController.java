package tn.esprit.pi.controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.configuration.EmailConfig;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.payload.LoginRequest;
import tn.esprit.pi.payload.ResetPassword;
import tn.esprit.pi.repository.UserRepository;

@RestController
public class ResetPasswordController {
	@Autowired
	EmailConfig emailCfg;
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordencoder;

	@PostMapping("/forget")
	public String processForgotPasswordForm(@RequestBody LoginRequest loginrequest, HttpServletRequest request) {

		User user = userRepository.findByName(loginrequest.getUsername()).get();

		user.setResetToken(UUID.randomUUID().toString());
		userRepository.save(user);
		String appUrl = request.getScheme() + "://" + request.getServerName();

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailCfg.getHost());
		mailSender.setPort(this.emailCfg.getPort());
		mailSender.setUsername(this.emailCfg.getUsername());
		mailSender.setPassword(this.emailCfg.getPassword());
		// Create an email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("ShoppyTounsi@Gmail.com");
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Reset  Ppassword ShoppyTounsi");
		mailMessage.setText(
				"To reset your password, click the link below:\n" + appUrl + "/reset?token=" + user.getResetToken());
		// Send mail
		mailSender.send(mailMessage);
		return user.getResetToken();
	}

	@PostMapping("/reset")
	public String setNewPassword(@Valid @RequestBody ResetPassword resetpass) {

		Optional<User> user = userRepository.findByResetToken(resetpass.getToken());

		User resetUser = user.get();

		// Set new password
		resetUser.setPassword(passwordencoder.encode(resetpass.getPassword()));

		// Set the reset token to null so it cannot be used again
		resetUser.setResetToken(null);

		// Save user
		userRepository.save(resetUser);
		return "password updated";
	}
}
