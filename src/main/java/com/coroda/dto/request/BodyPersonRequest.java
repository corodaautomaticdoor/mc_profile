package com.coroda.dto.request;

import com.coroda.entity.TypeDocument;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel("Model BodyPersonRequest")
@AllArgsConstructor
public class BodyPersonRequest {

   @ApiModelProperty(value = "typeDocument" , position = 1)
   private TypeDocument typeDocument;

   @ApiModelProperty(value = "numberDocument", required = true , position = 2)
   private Long numberDocument;

   @ApiModelProperty(value = "name", position = 3)
   private String name;


   }
