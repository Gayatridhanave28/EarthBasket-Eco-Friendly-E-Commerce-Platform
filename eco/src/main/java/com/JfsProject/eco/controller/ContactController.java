package com.JfsProject.eco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.dto.Contactdto;
import com.JfsProject.eco.model.Contact;
import com.JfsProject.eco.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	 @Autowired
	    private ContactService contactService;

	    @PostMapping("/send")
	    public Contact saveMessage(@RequestBody Contactdto dto){
	    	System.out.println("Contact API Called");

	        return contactService.saveMessage(dto);

	    }

	    @GetMapping
	    public List<Contact> getAllMessages(){

	        return contactService.getAllMessages();

	    }

	    @DeleteMapping("/{contactId}")
	    public String deleteMessage(@PathVariable Long contactId){

	        contactService.deleteMessage(contactId);

	        return "Message Deleted Successfully";

	    }
}
