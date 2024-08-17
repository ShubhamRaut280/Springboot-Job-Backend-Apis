package com.shubham.Firstspring.Services;

import com.shubham.Firstspring.Models.Company;
import com.shubham.Firstspring.Models.Reviews;
import com.shubham.Firstspring.Repositories.CompanyRepository;
import com.shubham.Firstspring.Services.Interfaces.CompanyServiceInterface;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;


@Service
public class CompanyService implements CompanyServiceInterface {
    private CompanyRepository repository;

    public CompanyService(CompanyRepository companyRepository){
        this.repository = companyRepository;
    }


    @Override
    public boolean addCompany(Company company) {
        repository.save(company);
        return true;
    }

    @Override
    public List<Company> getCompanies() {
        return repository.findAll();
    }
}
