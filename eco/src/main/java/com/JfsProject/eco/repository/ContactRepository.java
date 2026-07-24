package com.JfsProject.eco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JfsProject.eco.model.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
