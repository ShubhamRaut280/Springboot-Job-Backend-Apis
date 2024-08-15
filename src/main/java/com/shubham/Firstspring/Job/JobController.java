package com.shubham.Firstspring.Job;

import com.shubham.Firstspring.Models.Job;
import com.shubham.Firstspring.Services.JobService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private HttpStatus status;
    private final JobService jobService;

    JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    private ResponseEntity<List<Job>> getJobList(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully (through service)", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job response = jobService.getJobById(id);
        if(response==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean res = jobService.deleteJob(id);
        if(res)
            return new ResponseEntity<>("Job deleted succesfully", HttpStatus.OK);

         return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Job> updateJob(@PathVariable Long id , @RequestBody Job job){
        Job res = jobService.updateJob(id, job);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }

}
