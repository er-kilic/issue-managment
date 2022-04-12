package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.service.impl.IssueServiceImpl;
import com.temelt.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto dto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIssue(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
