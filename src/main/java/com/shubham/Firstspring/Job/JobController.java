package com.shubham.Firstspring.Job;

import com.shubham.Firstspring.Models.Job;
import com.shubham.Firstspring.Services.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;

    JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    private List<Job> getJobList(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    private String addJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully (through service)";
    }
}
