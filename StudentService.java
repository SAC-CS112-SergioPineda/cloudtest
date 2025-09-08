package com.example.cloudtestapp.service;

import com.example.cloudtestapp.entity.Student;
import java.util.List;

public interface StudentService {
  List<Student> findAll();
  Student findById(Long id);
  Student save(Student s);
  void delete(Long id);
}
