package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @Size(min = 1, max = 200, message = "Name must be between 1 and 200 characters")
    @NotBlank(message = "Name cannot be empty")
    private String description;
    @ManyToMany(mappedBy="skills")
    private List<Job> jobs = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    /*no arg constructor*/
    public Skill(){
    }
}
