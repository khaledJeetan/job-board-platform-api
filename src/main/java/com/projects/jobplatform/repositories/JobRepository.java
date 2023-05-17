package com.projects.jobplatform.repositories;


import com.projects.jobplatform.modles.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobRepository extends JpaRepository<Job,Long>, JpaSpecificationExecutor<Job> {

}
