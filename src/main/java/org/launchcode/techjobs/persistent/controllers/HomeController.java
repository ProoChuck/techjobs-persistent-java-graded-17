package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");
        List<Job> jobs = (List<Job>) jobRepository.findAll();
        model.addAttribute("jobs", jobs);

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        List<Employer> employers = (List<Employer>) employerRepository.findAll();
        List<Skill> skills = (List<Skill>) skillRepository.findAll();
        model.addAttribute("employers", employers);
        model.addAttribute("skills", skills);
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");
            return "add";
        }

        Optional<Employer> result = employerRepository.findById(employerId);
        if (result.isPresent()) {
            Employer employer = result.get();
            newJob.setEmployer(employer);
        }

        if (skills != null) {
            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
            newJob.setSkills(skillObjs);
        }

        jobRepository.save(newJob);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
// job repository find by id
        Optional<Job> job = jobRepository.findById(jobId);
// model add attribute jobs jobs
        model.addAttribute("job", job);
// model add attribute employers
        model.addAttribute("employers");
// model add attribute skills
        model.addAttribute("skills");
            return "view";
    }

}
