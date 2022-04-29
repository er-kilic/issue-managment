package com.temelt.issuemanagement.repository;

import com.temelt.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IssueRepository extends JpaRepository<Issue, Long> {

}
