package com.example.Spring_TasksScheduling.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    // To trigger the scheduler every one minute
    // between 19:00 PM to 19:59 PM
    @Scheduled(cron = "0 * 18 * * ?")
    public void scheduleTask1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

        String strDate = dateFormat.format(new Date());
        System.out.println("Cron job Scheduler: Job running at - " + strDate);
    }

    // To trigger the scheduler to run every two seconds
    @Scheduled(fixedRate = 2000)
    public void scheduleTask2() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

        String strDate = dateFormat.format(new Date());

        System.out.println("Fixed rate Scheduler: Task running at - " + strDate);
    }

    // To trigger the scheduler every 3 seconds with
    // an initial delay of 5 seconds.
    @Scheduled(fixedDelay = 3000, initialDelay = 5000)
    public void scheduleTask3() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

        String strDate = dateFormat.format(new Date());
        System.out.println("Fixed Delay Scheduler: Task running at - " + strDate);
    }
}
