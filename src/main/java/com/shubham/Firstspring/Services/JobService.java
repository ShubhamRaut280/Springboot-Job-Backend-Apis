package com.shubham.Firstspring.Services;

import com.shubham.Firstspring.Models.Job;
import com.shubham.Firstspring.Repositories.JobRepository;
import com.shubham.Firstspring.Services.Interfaces.JobServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobService implements JobServiceInterface {
//    private List<Job> jobList = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId = 1L;

    public JobService(JobRepository repository){
        this.jobRepository = repository;
    }


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id){
        Job job = jobRepository.findById(id).orElse(null);
        if(job==null)return false;

        jobRepository.deleteById(id);
        return true;

    }

    @Override
    public boolean clearDb() {
        try {
            jobRepository.deleteAll();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if(optionalJob.isPresent()){
            Job job1 = optionalJob.get();
                job1.setDescription(job.getDescription());
                job1.setLocation(job.getLocation());
                job1.setTitle(job.getTitle());
                job1.setMaxSalary(job.getMaxSalary());
                job1.setMinSalary(job.getMinSalary());
                job1.setCompany(job.getCompany());
                jobRepository.save(job1);
                return true;
        }
        else {
            return false;
        }

    }
}
