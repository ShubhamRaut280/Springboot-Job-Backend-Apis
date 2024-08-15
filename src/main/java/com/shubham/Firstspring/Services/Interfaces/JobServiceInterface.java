package com.shubham.Firstspring.Services.Interfaces;

import com.shubham.Firstspring.Models.Job;

import java.util.List;

public interface JobServiceInterface {
    List<Job> findAll();
    void createJob(Job job);
}
