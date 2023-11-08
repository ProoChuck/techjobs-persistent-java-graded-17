package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class Employer extends AbstractEntity {
    @Size(min = 1, max = 52, message = "Name must be between 1 and 52 characters")
    @NotNull(message = "Name cannot be empty")
    private String location;

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
