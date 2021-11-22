package com.coroda.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("Model BodyPersonRequest")
@AllArgsConstructor
public class ListBodyPersonRequest {

   @ApiModelProperty(value = "bodyPersonRequestList", required = true , position = 1)
   private List<BodyPersonRequest> bodyPersonRequestList;

   }
