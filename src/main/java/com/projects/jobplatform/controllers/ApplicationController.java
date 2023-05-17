package com.projects.jobplatform.controllers;

import com.projects.jobplatform.modles.Application;
import com.projects.jobplatform.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs/{jobId}/Applications")
public class ApplicationController {


    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping
    public List<Application> retrieveAllJobApplications(
            @PathVariable("jobId") Long jobId
    ){
        return applicationService.getAllJobApplications(jobId);
    }

    @GetMapping( "/{applicationId}")
    public ResponseEntity<Application> retrieveJobApplication(
            @PathVariable("jobId") Long jobId,
            @PathVariable("applicationId") Long applicationId
    ){
        return ResponseEntity.ok().body(applicationService.getJobApplication(jobId,applicationId));
    }


    @PostMapping
    public ResponseEntity<Application> createApplication(
            @PathVariable("jobId") Long jobId,
            @RequestBody Application application
    ){
        return ResponseEntity.ok().body(applicationService.addJobApplication(jobId,application));
    }

    @DeleteMapping("/{applicationId}")
    public ResponseEntity<String> deleteApplication(
            @PathVariable("jobId") Long jobId,
            @PathVariable("applicationId")Long applicationId
    ){
        return applicationService.deleteJobApplication(jobId,applicationId) ?
                ResponseEntity.ok().body("Job Deleted successfully.") :
                ResponseEntity.internalServerError().body("Error Job can't be Deleted!!.");
    }


    @PutMapping( "/{applicationId}")
    public ResponseEntity<Application> updateApplication(
            @PathVariable("jobId") Long jobId,
            @PathVariable("applicationId") Long applicationId,
            @RequestBody Application application){
        return ResponseEntity.ok().body(applicationService.updateJobApplication(jobId,applicationId,application));
    }


}
