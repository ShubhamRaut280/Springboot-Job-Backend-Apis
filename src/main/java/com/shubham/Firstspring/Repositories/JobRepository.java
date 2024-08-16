package com.shubham.Firstspring.Repositories;

import com.shubham.Firstspring.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
