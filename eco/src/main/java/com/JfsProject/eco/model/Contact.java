package com.JfsProject.eco.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contact {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long contactId;

	    private String name;

	    private String email;

	    private String subject;

	    @Column(length = 1000)
	    private String message;
}
