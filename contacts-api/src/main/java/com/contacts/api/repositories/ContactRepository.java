package com.contacts.api.repositories;

import com.contacts.api.entities.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findByFirstName(String name);
}
