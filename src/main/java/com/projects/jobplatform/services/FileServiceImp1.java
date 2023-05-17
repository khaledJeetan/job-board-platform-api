package com.projects.jobplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.UUID;

/*
    This class manages Images of Suppliers Products.
    The File structure as follows:-
        Folder[serverPath] ==> Folder[JobSeeker-UserName] ==> List<Folder[productId]>  ==>  List<Image[RandomImageName]>
 */

@Service
public class FileServiceImp1 implements FileService {

    private final Environment env;

    @Autowired
    public FileServiceImp1(Environment env) {
        this.env = env;
    }

    /*
    this method save a file of a specific User on the File System as Follow:-
        1- generate unique Name for the file
        2- get location path from app Properties file
        3- if  user and product directories not exist create them else save it
     */
    public String uploadFile(MultipartFile file, String userFolderName,String jobFolderName){

        String filePath;
        try {
        String fileName = UUID.randomUUID() + "." + file.getOriginalFilename().split("\\.")[1];
        String fileSaveLocation = env.getProperty("image.upload.path");
        File destDir = new File(fileSaveLocation+ jobFolderName+"\\"+userFolderName);
            if(!destDir.exists()){
                destDir.mkdirs();
            }
            filePath = destDir.getPath().concat("\\"+fileName);
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return filePath;

    }

    /*
    This method to delete all resume files of a specific Job
     */
    public boolean deleteFolder(String folderName){
        Path directory = Path.of(env.getProperty("file.upload.path") + "\\" + folderName);
        try {
            if(!directory.toFile().exists())
                return true;
            Files.walk(directory)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public FileSystemResource getFile(String fileUrl) {
        return  new FileSystemResource(fileUrl);
    }


}
