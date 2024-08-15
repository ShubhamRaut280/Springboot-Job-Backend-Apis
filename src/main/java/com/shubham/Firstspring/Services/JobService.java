package com.shubham.Firstspring.Services;

import com.shubham.Firstspring.Models.Job;
import com.shubham.Firstspring.Services.Interfaces.JobServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements JobServiceInterface {
    private List<Job> jobList = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobList;
    }

    @Override
    public void createJob(Job job) {
        jobList.add(job);
    }
}
