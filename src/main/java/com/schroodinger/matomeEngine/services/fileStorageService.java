package com.schroodinger.matomeEngine.services;

import com.schroodinger.matomeEngine.Exceptions.FileStorageException;
import com.schroodinger.matomeEngine.Exceptions.MyFileNotFoundException;
import com.schroodinger.matomeEngine.models.fileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class fileStorageService {

    private  final Path fileStorageLocation;


    @Autowired
    public  fileStorageService(fileStorageProperties  fileproperties){

        this.fileStorageLocation = Paths.get(fileproperties.getUploadDir())
                .toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);
        }
        catch (Exception ex){
            throw new FileStorageException("Could not create directory for uploaded file");
        }
    }

    public  String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //check if file name contain any invalid chars
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("file contains invalid chars");
            }


            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }catch (Exception ex){
            throw new FileStorageException("file contains invalid chars");
        }
    }


    public UrlResource loadFileAsResource(String fileName){
        try{
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            UrlResource resource = new UrlResource(filePath.toUri());
            if(resource.exists()){
                return  resource;
            }
            else{
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        }catch (MalformedURLException ex){
            throw new MyFileNotFoundException("File not found " + fileName, ex);

        }
    }

}
