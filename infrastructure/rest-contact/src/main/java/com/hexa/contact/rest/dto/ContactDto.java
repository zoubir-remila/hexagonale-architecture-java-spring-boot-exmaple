package com.hexa.contact.rest.dto;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ContactDto {
    private Long id;
    private String firstName;
    private String lastName;
    private OffsetDateTime dateOfBirth;

}
