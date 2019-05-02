package com.hexa.contact.domain.usecases;

import com.hexa.contact.domain.entities.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);

    List<Contact> findAll();

    Contact findContact(Long id);

    Contact updateContact(Contact contact);

    void deleleContact(Contact contact);
}
