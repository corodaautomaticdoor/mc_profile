package com.coroda.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
@Data
@Entity
@Table ( name  =  "person" )
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    @Column(name = "typeDocument")
    private TypeDocument typeDocument;

    @Column(name = "typePerson")
    private TypePerson typePerson;

    @Column(name = "numberDocument")
    private Long numberDocument;

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
    @Email
    private String email;

    @Column(name = "phone")
//    @Pattern(regexp = "[0-9]+",message = "ingresar solo números")
//    @Size(min = 9 , max = 9 , message = "ingrese correctamente su número")
     private long phone;

}

