package com.contacts.api.web.controllers;

import com.contacts.api.entities.Contact;
import com.contacts.api.repositories.ContactRepository;
import com.contacts.api.repositories.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping
    public List<Contact> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Contact getById(@PathVariable String id) {
        return this.service.getById(id);
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return this.service.create(contact);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        return this.service.update(id, contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.service.delete(id);
    }
}
