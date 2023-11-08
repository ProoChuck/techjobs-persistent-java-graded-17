package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Skill extends AbstractEntity {
    @Size(min = 1, max = 200, message = "Name must be between 1 and 200 characters")
    @NotBlank(message = "Name cannot be empty")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /*no arg constructor*/
    public Skill(){
    }
}
