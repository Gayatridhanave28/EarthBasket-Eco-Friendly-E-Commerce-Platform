package com.JfsProject.eco.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Data
public class Logindto {
	@Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}
