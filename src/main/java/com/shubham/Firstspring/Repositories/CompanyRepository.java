package com.shubham.Firstspring.Repositories;

import com.shubham.Firstspring.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
