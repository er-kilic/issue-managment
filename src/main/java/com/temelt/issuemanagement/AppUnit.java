package com.temelt.issuemanagement;

import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class AppUnit implements CommandLineRunner {
    @Autowired
    ProjectServiceImpl projectService;

    @Override
    public void run(String... args) throws Exception {
        Project p = new Project();
        p.setProjectCode("12345");
        p.setProjectName("Deneme");
        projectService.save(p);

    }
}
