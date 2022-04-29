package com.temelt.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue DTO")
public class ProjectDto {
    @ApiModelProperty(required = true,value = "Proje Id")
    private Long id;
    @ApiModelProperty(required = true,value = "Proje İsmi")
    @NotNull
    private String projectName;
    @ApiModelProperty(required = true,value = "Proje Kodu")
    @NotNull
    private String projectCode;
}
