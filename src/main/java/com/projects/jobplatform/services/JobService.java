package com.projects.jobplatform.services;

import com.projects.jobplatform.modles.Job;
import com.projects.jobplatform.repositories.JobRepository;
import com.projects.jobplatform.specification.JobSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;


    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJob(Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow( () -> new IllegalStateException(
                        "Job with Id " + jobId +  "doesn't Exsist"
                        )
                );
    }


    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public boolean deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
        return true;
    }

    public Job updateJob(Long jobId, Job job) {
        Job oldJob = getJob(jobId);
        oldJob.setDescription(job.getDescription());
        oldJob.setLocation(job.getLocation());
        oldJob.setRequirements(job.getRequirements());
        oldJob.setTitle(job.getTitle());
        oldJob.setSalaryRange(job.getSalaryRange());
        return oldJob;
    }

    public Page<Job> searchJobs(String title, String location , double minSalary, double maxSalary, Pageable pageable) {
        Specification<Job> spec = Specification.where(JobSpecifications.withTitle(title))
                .and(JobSpecifications.withLocation(location))
                .and( JobSpecifications.withSalaryRange(minSalary,maxSalary));
        return jobRepository.findAll(spec,pageable);
    }

}
