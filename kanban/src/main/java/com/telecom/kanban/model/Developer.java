package com.telecom.kanban.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Developer {


    @Id
    @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private String firstname;
    @Getter @Setter private String lastname;
    @Getter @Setter private String password;

    @Column(unique = true)
    @Getter @Setter private String email;
    @Getter @Setter private Date startContact;

    @ManyToMany(mappedBy = "developers", cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @Getter @Setter private Set<Task> tasks;

    public Developer(String firstname, String lastname, String password, String email, Date startContact) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.startContact = startContact;
    }
}
