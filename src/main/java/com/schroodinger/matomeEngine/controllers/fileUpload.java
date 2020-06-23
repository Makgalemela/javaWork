package com.schroodinger.matomeEngine.controllers;


import com.schroodinger.matomeEngine.response.uploadFileResponse;
import com.schroodinger.matomeEngine.services.fileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class fileUpload {

    private static final Logger logger = LoggerFactory.getLogger(fileUpload.class);


    @Autowired
    private fileStorageService fileStorage;

    @PostMapping("/uploadFile")
    public uploadFileResponse uploadFile(@RequestParam("file")MultipartFile file){
        String fileName =  fileStorage.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new uploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
}
