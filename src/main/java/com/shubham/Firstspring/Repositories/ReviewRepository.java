package com.shubham.Firstspring.Repositories;

import com.shubham.Firstspring.Models.Company;
import com.shubham.Firstspring.Models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findByCompanyId(Long id);
}
