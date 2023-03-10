package com.contacts.api.repositories.services;

import com.contacts.api.entities.Contact;
import com.contacts.api.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository repository;

    @Override
    public List<Contact> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Contact getById(String id) {
        return this.repository.findById(id).orElseThrow(() -> { throw new RuntimeException("contact con id " + id + "does nor exist"); });
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact update(String id, Contact contact) {
        Contact currentContact = this.repository.findById(id).orElseThrow(() -> { throw new RuntimeException("contact con id " + id + "does nor exist"); });

        currentContact.setFirstName(contact.getFirstName());
        currentContact.setLastName(contact.getLastName());
        currentContact.setEmail(contact.getEmail());
        currentContact.setPhone(contact.getPhone());
        currentContact.setBirthday(contact.getBirthday());
        currentContact.setAddress(contact.getAddress());

        return this.repository.save(currentContact);
    }

    @Override
    public void delete(String id) {
        Contact currentContact = this.repository.findById(id).orElseThrow(() -> { throw new RuntimeException("contact con id " + id + "does nor exist"); });
        this.repository.delete(currentContact);
    }
}
