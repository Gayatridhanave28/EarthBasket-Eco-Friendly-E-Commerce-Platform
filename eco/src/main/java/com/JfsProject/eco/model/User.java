package com.JfsProject.eco.model;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long userId;
	
	@NotBlank(message="Username can not be blank")
	private String name;
	
	 private String email;
	    private String password;

	    private String role;
	
}
