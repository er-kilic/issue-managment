package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.impl.ProjectServiceImpl;
import com.temelt.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/versioning")
@Api(value = "/versioning", description = "Project API")
public class ProjectVersionedApi {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectVersionedApi(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping(value = "/{id}", params = "version=1")
    @ApiOperation(value = "V1 Proje Id bazlı getir", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV1(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto dto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}", params = "version=2")
    @ApiOperation(value = "V2 Proje Id bazlı getir", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV2(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto dto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @ApiOperation(value = "Proje Oluştur", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Proje Güncelle", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Proje Sil", response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
