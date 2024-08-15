package com.shubham.Firstspring.Services;

import com.shubham.Firstspring.Models.Job;
import com.shubham.Firstspring.Services.Interfaces.JobServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Job> it = jobList.iterator();
        while(it.hasNext()){
            if(it.next().getId().equals(id)){
                it.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public Job updateJob(Long id, Job job) {
        for(int i = 0; i < jobList.size(); i++){
            if(jobList.get(i).getId().equals(id)){
                jobList.get(i).setDescription(job.getDescription());
                jobList.get(i).setLocation(job.getLocation());
                jobList.get(i).setTitle(job.getTitle());
                jobList.get(i).setMaxSalary(job.getMaxSalary());
                jobList.get(i).setMinSalary(job.getMinSalary());
                return jobList.get(i);
            }
        }
        jobList.add(job);
        return  job;
    }
}
