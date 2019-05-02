package com.hexa.contact.rest;

import com.hexa.contact.domain.entities.Contact;
import com.hexa.contact.domain.usecases.ContactCreator;
import com.hexa.contact.rest.dto.ContactDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactRessource {

    private ContactCreator contactCreator;


    public ContactRessource(ContactCreator contactCreator) {
        this.contactCreator = contactCreator;
    }

    private Logger LOGGER = LoggerFactory.getLogger(ContactRessource.class);

    @PostMapping
    public ContactDto createContact(@RequestBody ContactDto contactDto) throws Exception {
        LOGGER.info("Creation of a new ContactEntity ");
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        Contact contact = mapperFacade.map(contactDto, Contact.class);
        Contact contactSaved = contactCreator.createContact(contact);
        return mapperFacade.map(contactSaved, ContactDto.class);
    }

    @GetMapping
    public List<ContactDto> getAllContacts() {
        LOGGER.info("Get all contacts ");
        List<Contact> contacts = contactCreator.getAllContacts();
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        return mapperFacade.mapAsList(contacts, ContactDto.class);
    }

    @GetMapping("/contact")
    public ContactDto getContact(@RequestParam Long id) {
        LOGGER.info("------------------");
        LOGGER.info("|     id {}       |", id);
        LOGGER.info("------------------");
        Contact contact = contactCreator.getContact(id);
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        return mapperFacade.map(contact, ContactDto.class);

    }

    @PutMapping
    public ContactDto updateContact(@RequestBody ContactDto contactDto) {
        LOGGER.info("------------------");
        LOGGER.info("|      id [{}]    |", contactDto.getId());
        LOGGER.info("------------------");
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        Contact contact = mapperFacade.map(contactDto, Contact.class);
        Contact updatedContact = contactCreator.updateContact(contact);
        return mapperFacade.map(updatedContact, ContactDto.class);
    }

    @DeleteMapping
    public void deleteContact(@RequestBody ContactDto contactDto){
        LOGGER.info("------------------");
        LOGGER.info("|      id [{}]    |", contactDto.getId());
        LOGGER.info("------------------");
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        Contact contact = mapperFacade.map(contactDto, Contact.class);
        contactCreator.deleteContact(contact);

    }
}
