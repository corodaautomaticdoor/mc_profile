package com.coroda.dto.response;

import com.coroda.entity.TypeDocument;
import com.coroda.entity.TypePerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

    private long idPerson;

    private TypeDocument typeDocument;

    private TypePerson typePerson;

    private Long numberDocument;

    private String name;

    private String lastName1;

    private String lastName2;

    private String socialReason;

    private String address;

    private String email;

    private long phone;

}
