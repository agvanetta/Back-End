package com.example1.ORM.service;

import com.example1.ORM.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> findAllStudents();

    Optional<Student> findStudentById(Long id);
    Student saveStudent(Student student);
    String deletStudent(Long id);
    String updateStudent(Student studentNew);

}
