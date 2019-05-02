package com.hexa.contact.persistence.repositories;

import com.hexa.contact.persistence.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaContactRepository extends JpaRepository<ContactEntity, Long> {
}
