package com.hexa.contact.rest.adapters;

import com.hexa.contact.domain.entities.Contact;
import com.hexa.contact.domain.usecases.ContactRepository;
import com.hexa.contact.persistence.entities.ContactEntity;
import com.hexa.contact.persistence.repositories.JpaContactRepository;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactAdapter implements ContactRepository {
    @Autowired
    private JpaContactRepository jpaContactRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(ContactAdapter.class);

    public ContactAdapter(JpaContactRepository jpaContactRepository) {
        this.jpaContactRepository = jpaContactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        ContactEntity contactEntity = mapperFacade.map(contact, ContactEntity.class);
        ContactEntity save = jpaContactRepository.save(contactEntity);
        LOGGER.info("Contact saved with id {} ", save.getId());
        return mapperFacade.map(save, Contact.class);
    }

    @Override
    public List<Contact> findAll() {
        List<ContactEntity> all = jpaContactRepository.findAll();
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        List<Contact> contactEntities = mapperFacade.mapAsList(all, Contact.class);
        LOGGER.info("Contacts size is {} ", contactEntities.size());
        return contactEntities;
    }

    @Override
    public Contact findContact(Long id) {
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        Optional<ContactEntity> contact = jpaContactRepository.findById(id);
        return contact.map(contactEntity -> mapperFacade.map(contactEntity, Contact.class)).orElse(null);

    }

    @Override
    public Contact updateContact(Contact contact) {
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        ContactEntity contactEntity = mapperFacade.map(contact, ContactEntity.class);
        jpaContactRepository.save(contactEntity);
        Optional<ContactEntity> contactUpdated = jpaContactRepository.findById(contact.getId());
        return contactUpdated.map(entity -> mapperFacade.map(entity, Contact.class)).orElse(null);
    }

    @Override
    public void deleleContact(Contact contact) {
        MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
        jpaContactRepository.delete(mapperFacade.map(contact, ContactEntity.class));
    }


}
