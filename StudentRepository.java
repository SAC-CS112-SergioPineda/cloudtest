package com.example.cloudtestapp.repository;

import com.example.cloudtestapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}

