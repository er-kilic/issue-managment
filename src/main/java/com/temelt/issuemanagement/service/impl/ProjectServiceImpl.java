package com.temelt.issuemanagement.service.impl;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.repository.ProjectRepository;
import com.temelt.issuemanagement.service.ProjectService;
import com.temelt.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());
        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        Project p = modelMapper.map(projectDto, Project.class);
        p = projectRepository.save(p);
        projectDto.setId(p.getId());
        return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getById(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project project = projectRepository.getOne(id);
        if (project == null) {
            throw new IllegalArgumentException("Project Does Not Exist ID: " + id);
        }
        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());
        if (projectCheck != null && projectCheck.getId() != project.getId()) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByPorjectContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

}
