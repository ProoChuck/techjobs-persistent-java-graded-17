package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @Size(min = 1, max = 52, message = "Name must be between 1 and 52 characters")
    @NotBlank(message = "Name cannot be empty")
    private String location;
    @JoinColumn(name = "employer_id")
    @OneToMany
    private final List<Job> jobs = new ArrayList<>();
    public List<Job> getJobs() {
        return jobs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    /*no arg constructor*/
    public Employer(){
    }
}
