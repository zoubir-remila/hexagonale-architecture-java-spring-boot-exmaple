package com.hexa.contact.domain.entities;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private OffsetDateTime dateOfBirth;
}
