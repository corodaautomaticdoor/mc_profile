package com.coroda.dto.request;

import com.coroda.entity.TypeDocument;
import com.coroda.entity.TypePerson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel("Model Person")
@AllArgsConstructor
public class PersonRequest {

   @ApiModelProperty("id")
   private long idPerson;

   @ApiModelProperty("typeDocument")
   private TypeDocument typeDocument;

   @ApiModelProperty("typePerson")
   private TypePerson typePerson;

   @ApiModelProperty("name")
   private String name;

   @ApiModelProperty("lastName1")
   private String lastName1;

   @ApiModelProperty("lastName2")
   private String lastName2;

   @ApiModelProperty("socialReason")
   private String socialReason;

   @ApiModelProperty("address")
   private String address;

   @ApiModelProperty("email")
   private String email;

   @ApiModelProperty("phone")
   private long phone;

   }
