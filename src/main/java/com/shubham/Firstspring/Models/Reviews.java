package com.shubham.Firstspring.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String content;
    boolean type;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }


    public void setCompany(Company company) {
        this.company = company;
    }

    public Reviews() {
    }

    public Reviews(Long id, String content, boolean type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
