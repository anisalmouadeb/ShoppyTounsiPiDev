package tn.esprit.pi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.repository.ShelfRepository;
import tn.esprit.pi.service.ShelfServiceImpl;

@SpringBootApplication
@EnableScheduling
public class ShoppyTounsiPiDev4sae3Application {

	public static void main(String[] args) {
		SpringApplication.run(ShoppyTounsiPiDev4sae3Application.class, args);
		
	

	}

}
