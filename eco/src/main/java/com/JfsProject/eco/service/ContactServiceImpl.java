package com.JfsProject.eco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.dto.Contactdto;
import com.JfsProject.eco.model.Contact;
import com.JfsProject.eco.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact saveMessage(Contactdto dto) {

        Contact contact = new Contact();

        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());
        contact.setSubject(dto.getSubject());
        contact.setMessage(dto.getMessage());

        return contactRepository.save(contact);
    }
    
    @Override
    public List<Contact> getAllMessages() {

        return contactRepository.findAll();
    }

    @Override
    public void deleteMessage(Long contactId) {

        contactRepository.deleteById(contactId);

    }
}
