package com.shubham.Firstspring.Services;

import com.shubham.Firstspring.Models.Job;
import com.shubham.Firstspring.Services.Interfaces.JobServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements JobServiceInterface {
    private List<Job> jobList = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobList;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobList.add(job);
    }

    @Override
    public Job getJobById(Long id){
        for(Job i : jobList){
            if(i.getId().equals(id))
                return i;
        }

        return null;
    }

    @Override
    public boolean deleteJob(Long id){
        for(Job job : jobList){
            if(job.getId().equals(id)){
                jobList.remove(job);
                return true;
            }
        }

        return false;
    }


}
