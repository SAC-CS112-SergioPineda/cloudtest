package com.example.cloudtestapp.service;

import com.example.cloudtestapp.entity.Student;
import com.example.cloudtestapp.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  private final StudentRepository repo;
  public StudentServiceImpl(StudentRepository repo) { this.repo = repo; }

  @Override public List<Student> findAll() { return repo.findAll(); }
  @Override public Student findById(Long id) { return repo.findById(id).orElseThrow(); }
  @Override public Student save(Student s) { return repo.save(s); }
  @Override public void delete(Long id) { repo.deleteById(id); }
}

