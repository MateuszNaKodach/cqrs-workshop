package io.github.nowakprojects.cqrsworkshop.withoutcqrs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String emailAddress;
}
