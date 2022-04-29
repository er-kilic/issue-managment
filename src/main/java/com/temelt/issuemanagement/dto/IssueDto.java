package com.temelt.issuemanagement.dto;

import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project DTO")
public class IssueDto {
    @ApiModelProperty(required = true,value = "İş Id")
    private Long id;
    @ApiModelProperty(value = "Açıklama")
    private String description;
    @ApiModelProperty(value = "Detay")
    private String details;
    @ApiModelProperty(value = "Gün")
    private Date date;
    @ApiModelProperty(value = "İş Statü")
    private IssueStatus issueStatus;
    @ApiModelProperty(value = "Atanan (UserDTO)")
    private UserDto assignee;
    @ApiModelProperty(value = "Project")
    private ProjectDto project;
}
