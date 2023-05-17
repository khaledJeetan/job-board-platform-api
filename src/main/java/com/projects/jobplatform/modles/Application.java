package com.projects.jobplatform.modles;

import com.projects.jobplatform.services.FileService;
import com.projects.jobplatform.services.FileServiceImp1;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resumeUrl;

    private String coverLetterUrl;

    private Status status;

    @ManyToOne
    private User applicant;

    @ManyToOne
    private Job job;

    @Transient
    private MultipartFile coverLetterFile;

    @Transient
    private MultipartFile resumeFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getCoverLetterUrl() {
        return coverLetterUrl;
    }

    public void setCoverLetterUrl(String coverLetterUrl) {
        this.coverLetterUrl = coverLetterUrl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public MultipartFile getCoverLetterFile() {
        return coverLetterFile;
    }

    public void setCoverLetterFile(MultipartFile coverLetterFile) {
        this.coverLetterFile = coverLetterFile;
    }

    public MultipartFile getResumeFile() {
        return resumeFile;
    }

    public void setResumeFile(MultipartFile resumeFile) {
        this.resumeFile = resumeFile;
    }
}
