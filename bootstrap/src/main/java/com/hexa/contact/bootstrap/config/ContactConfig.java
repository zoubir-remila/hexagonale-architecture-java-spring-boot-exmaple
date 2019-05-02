package com.hexa.contact.bootstrap.config;

import com.hexa.contact.domain.usecases.ContactCreator;
import com.hexa.contact.domain.usecases.ContactRepository;
import com.hexa.contact.domain.usecases.CreateContact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfig {

    @Bean
    ContactCreator contactCreator(ContactRepository contactRepository) {
        return new CreateContact(contactRepository);
    }


}
