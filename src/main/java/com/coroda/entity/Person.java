package com.coroda.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table ( name  =  "person" )
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerson")
    private Long idPerson;

    @Column(name = "typeDocument")
    private TypeDocument typeDocument;

    @Column(name = "typePerson")
    private TypePerson typePerson;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName1")
    private String lastName1;

    @Column(name = "lastName2")
    private String lastName2;

    @Column(name = "socialReason")
    private String socialReason;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
     private long phone;



/*
    @OneToOne(mappedBy = "person")
    private User user;
*/
}

