package com.example.SpringBatch_Processing_csvToDB.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final String TEMP_STORAGE = "/home/admin1/Documents/csv";
    public static final String TEMP_STORAGE_PATH = "/Users/javatechie/Desktop/temp/";

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @GetMapping("/importCsv")
    public void importCsvToDBJob() {
        JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
//                .addLong("startAt", System.currentTimeMillis()).toJobParameters();            //add for executing the job again and again
        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/importCsv")
    public void importCsvToDBJobByQueryParam(@RequestParam("csv")MultipartFile multipartFile) {
        try {
            String originalFileName= multipartFile.getOriginalFilename();
            File fileToImport = new File(TEMP_STORAGE + originalFileName);
            multipartFile.transferTo(fileToImport);
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("fullpathfilename",TEMP_STORAGE+originalFileName).toJobParameters();
//                .addLong("startAt", System.currentTimeMillis()).toJobParameters();            //add for executing the job again and again

            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException | IOException e) {
            e.printStackTrace();
        }
    }
}
