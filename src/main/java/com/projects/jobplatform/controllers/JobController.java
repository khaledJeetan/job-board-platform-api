package com.projects.jobplatform.controllers;

import com.projects.jobplatform.modles.Job;
import com.projects.jobplatform.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;


    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> retrieveAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping( "/{jobId}")
    public ResponseEntity<Job> retrieveJob(
            @PathVariable("jobId") Long jobId
    ){
        return ResponseEntity.ok().body(jobService.getJob(jobId));
    }

    @GetMapping("/search")
    public Page<Job> getSearchedJobs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) double minSalary,
            @RequestParam(required = false) double maxSalary,
            Pageable pageable
            ){
        return jobService.searchJobs(title,location,minSalary,maxSalary,pageable);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        return ResponseEntity.ok().body(jobService.addJob(job));
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable("jobId")Long jobId){
        return jobService.deleteJob(jobId) ?
                ResponseEntity.ok().body("Job Deleted successfully.") :
                ResponseEntity.internalServerError().body("Error Job can't be Deleted!!.");
    }


    @PutMapping( "/{jobId}")
    public ResponseEntity<Job> updateJob(
            @PathVariable("jobId") Long jobId,
            @RequestBody Job job){
        return ResponseEntity.ok().body(jobService.updateJob(jobId,job));
    }


}
