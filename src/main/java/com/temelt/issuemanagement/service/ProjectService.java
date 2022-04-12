package com.temelt.issuemanagement.service;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto projectDto);

    ProjectDto getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByPorjectContains(String projectCode);

    Boolean delete (Long id);

    ProjectDto update(Long id, ProjectDto projectDto);
}
