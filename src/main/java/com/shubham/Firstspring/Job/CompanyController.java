package com.shubham.Firstspring.Job;

import com.shubham.Firstspring.Models.Company;
import com.shubham.Firstspring.Models.Reviews;
import com.shubham.Firstspring.Services.CompanyService;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/companies")
public class CompanyController {
     CompanyService companyService;

     CompanyController(CompanyService service) {
        this.companyService = service;
    }

    @GetMapping
    private ResponseEntity<List<Company>> getCompanies(){
         return new ResponseEntity<>(companyService.getCompanies(), OK);
    }

    @PostMapping
    private ResponseEntity<String> addCompany(@RequestBody Company company){
         boolean res  = companyService.addCompany(company);
         return new ResponseEntity<>("Company added" , CREATED);
    }


}
