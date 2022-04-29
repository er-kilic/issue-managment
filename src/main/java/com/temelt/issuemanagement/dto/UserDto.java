package com.temelt.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User DTO")
public class UserDto {
    @ApiModelProperty(required = true,value = "Kullanıcı Id")
    private Long id;
    @ApiModelProperty(required = true,value = "Adı Soyadı")
    private String nameSurname;
}
