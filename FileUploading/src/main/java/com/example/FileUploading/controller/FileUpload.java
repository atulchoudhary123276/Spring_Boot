package com.example.FileUploading.controller;

import com.example.FileUploading.helper.FileUploaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUpload {
    @Autowired
    FileUploaderHelper fileUploaderHelper;
    @PostMapping("/uploadImg")
    public ResponseEntity<String> uploadImgfile(@RequestParam("file") MultipartFile file){
       try {
           if (file.isEmpty()) {
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please attach any file");
           } else if (!file.getContentType().equals("image/jpeg")) {
               return ResponseEntity.status(HttpStatus.CONFLICT).body("Only JPEG format are allowed");
           }
           //file uploading code
           boolean result = fileUploaderHelper.uploadFile(file);
           if (result){
            //  return ResponseEntity.status(HttpStatus.OK).body("File upload successful");

               //it return upload file path to client
               return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
           }

       }
       catch (Exception e){
           e.printStackTrace();
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong! Try again ");
    }
}
