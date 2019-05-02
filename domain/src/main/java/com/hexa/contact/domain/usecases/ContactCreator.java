package com.hexa.contact.domain.usecases;

import com.hexa.contact.domain.entities.Contact;

import java.util.List;

public interface ContactCreator {
    Contact createContact(Contact contact) throws Exception;

    List<Contact> getAllContacts();

    Contact getContact(Long id);

    Contact updateContact(Contact contactDto);

    void deleteContact(Contact contact);
}
