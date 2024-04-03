package com.example.FileUploading.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploaderHelper {
//    static file path
//    public final String UPLOAD_DIR="/home/admin1/IdeaProjects/Spring_Boot/FileUploading/src/main/resources/static/images";

    //dynamic file path -and by this path file is upload on TARGET Folder(this folder is genrate when app is build and serve
             // resource at server side) Static/image directory
    public final String UPLOAD_DIR=new ClassPathResource("static/images/").getFile().getAbsolutePath();
    public FileUploaderHelper() throws IOException {
    }

    public boolean uploadFile(MultipartFile multipartFile){
        boolean flag=false;

        try {
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            flag=true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
