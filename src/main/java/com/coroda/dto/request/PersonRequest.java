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

   @ApiModelProperty(value = "id", required = true , position = 1)
   private long idPerson;

   @ApiModelProperty(value = "typeDocument", required = true , position = 2)
   private TypeDocument typeDocument;

   @ApiModelProperty(value = "typePerson", required = true , position = 3)
   private TypePerson typePerson;

   @ApiModelProperty(value = "numberDocument", required = true , position = 4)
   private Long numberDocument;

   @ApiModelProperty(value = "name", required = true , position = 5)
   private String name;

   @ApiModelProperty(value = "lastName1", required = true , position = 6)
   private String lastName1;

   @ApiModelProperty(value = "lastName2", required = true , position = 7)
   private String lastName2;

   @ApiModelProperty(value = "socialReason", required = true , position = 8)
   private String socialReason;

   @ApiModelProperty(value = "address", required = true , position = 9)
   private String address;

   @ApiModelProperty(value = "email", required = true , position = 10)
   private String email;

   @ApiModelProperty(value = "phone", required = true , position = 11)
   private long phone;

   }
