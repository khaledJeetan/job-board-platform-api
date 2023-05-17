package com.projects.jobplatform.services;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public interface FileService {

    FileSystemResource getFile(String fileUrl);

    boolean deleteFolder(String folderName);

    String uploadFile(MultipartFile file,String userFolderName, String jobFolderName);

}
