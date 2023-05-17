package com.projects.jobplatform.repositories;

import com.projects.jobplatform.modles.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ApplicationRepository extends JpaRepository<Application,Long> {

    List<Application> findAllByJob_Id(Long jobId);

    Optional<Application> findApplicationByIdAndAndJob_Id(Long applicationId,Long jobId);

}
