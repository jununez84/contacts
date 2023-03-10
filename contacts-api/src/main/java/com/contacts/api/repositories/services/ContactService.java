package com.contacts.api.repositories.services;

import com.contacts.api.entities.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getAll();
    public Contact getById(String id);
    public Contact create(Contact contact);
    public Contact update(String id, Contact contact);
    public void delete(String id);
}
