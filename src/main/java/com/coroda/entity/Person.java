package com.coroda.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Pattern(regexp = "[a-zA-ZÁáÉéÍíÓóÚúÑñ]+",message = "ingresar solo letras")
    private String name;

    @Column(name = "lastName1")
    @Pattern(regexp = "[a-zA-ZÁáÉéÍíÓóÚúÑñ]+",message = "ingresar solo letras")
    private String lastName1;

    @Column(name = "lastName2")
    @Pattern(regexp = "[a-zA-ZÁáÉéÍíÓóÚúÑñ]+",message = "ingresar solo letras")
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



/*
    @OneToOne(mappedBy = "person")
    private User user;
*/
}

