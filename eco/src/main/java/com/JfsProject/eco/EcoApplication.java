package com.JfsProject.eco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.JfsProject.eco.model.User;
import com.JfsProject.eco.repository.UserRepository;

@SpringBootApplication
public class EcoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner createAdmin(UserRepository userRepo) {
	    return args -> {

	        System.out.println("Checking Admin...");

	        User existingAdmin = userRepo.findByEmail("admin@gmail.com");

	        if (existingAdmin == null) {

	            System.out.println("Admin not found. Creating Admin...");

	            User admin = new User();

	            admin.setName("Admin");
	            admin.setEmail("admin@gmail.com");
	            admin.setPassword("admin123");
	            admin.setRole("ROLE_ADMIN");

	            userRepo.save(admin);

	            System.out.println("Admin Created Successfully.");
	        } else {

	            System.out.println("Admin Already Exists.");

	        }
	    };
	}
}
