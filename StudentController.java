package com.example.cloudtestapp.controller;

import com.example.cloudtestapp.entity.Student;
import com.example.cloudtestapp.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", repo.findAll());
        return "list";
    }

    // NEW FORM
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    // CREATE
    @PostMapping
    public String create(@Valid @ModelAttribute("student") Student student,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        repo.save(student);
        return "redirect:/students";
    }

    // EDIT FORM
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("student", s);
        return "form";
    }
  }
    // UPDATE
