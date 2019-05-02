package com.hexa.contact.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "contact")
public class ContactEntity {
    @Id
    @NotNull
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    private OffsetDateTime dateOfBirth;
}
