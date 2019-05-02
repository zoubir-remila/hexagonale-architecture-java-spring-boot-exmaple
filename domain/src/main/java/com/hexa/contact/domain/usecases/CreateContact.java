package com.hexa.contact.domain.usecases;

import com.hexa.contact.domain.entities.Contact;

import java.util.List;

public class CreateContact implements ContactCreator {

    ContactRepository contactRepository;

    public CreateContact(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) throws Exception {
        if (null == contact.getFirstName()) {
            throw new Exception("no first name ");
        }
        return contactRepository.save(contact);

    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findContact(id);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.updateContact(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.deleleContact(contact);
    }

}
