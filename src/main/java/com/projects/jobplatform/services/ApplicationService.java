package com.projects.jobplatform.services;

import com.projects.jobplatform.modles.Application;
import com.projects.jobplatform.modles.Job;
import com.projects.jobplatform.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobService jobService;


    public ApplicationService(ApplicationRepository applicationRepository, JobService jobService) {
        this.applicationRepository = applicationRepository;
        this.jobService = jobService;
    }


    public List<Application> getAllJobApplications(Long jobId) {
        return jobService.getJob(jobId).getApplications();
    }

    public Application getJobApplication(Long jobId, Long applicationId) {
        return applicationRepository.findApplicationByIdAndAndJob_Id(applicationId,jobId)
                .orElseThrow(
                        () -> new IllegalStateException(
                                "Application doesn't exist or doesn't belong To this Job"
                        )
                );
    }

    @Transactional
    public Application addJobApplication(Long jobId, Application application) {
        Job job = jobService.getJob(jobId);
        job.getApplications().add(application);
        return application;
    }

    @Transactional
    public Application updateJobApplication(Long jobId, Long applicationId, Application application) {
        Application oldApplication = getJobApplication(jobId,applicationId);
        oldApplication.setStatus(application.getStatus());
        return oldApplication;
    }

    public boolean deleteJobApplication(Long jobId, Long applicationId) {
        jobService.getJob(jobId);
        applicationRepository.deleteById(applicationId);
        return true;
    }
}
