package com.shubham.Firstspring.Services.Interfaces;

import com.shubham.Firstspring.Models.Company;
import com.shubham.Firstspring.Models.Reviews;

import java.util.List;

public interface CompanyServiceInterface {
    boolean addCompany(Company company);
    List<Company> getCompanies();
}
