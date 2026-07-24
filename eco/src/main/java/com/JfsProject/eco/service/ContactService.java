package com.JfsProject.eco.service;

import java.util.List;

import com.JfsProject.eco.dto.Contactdto;
import com.JfsProject.eco.model.Contact;

public interface ContactService {
	Contact saveMessage(Contactdto dto);

    List<Contact> getAllMessages();

    void deleteMessage(Long contactId);
}
