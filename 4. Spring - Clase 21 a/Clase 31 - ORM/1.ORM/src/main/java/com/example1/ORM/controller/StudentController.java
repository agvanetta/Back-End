package com.example1.ORM.controller;

import com.example1.ORM.entity.Student;
import com.example1.ORM.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


    private final StudentServiceImpl studentService;

    StudentController (StudentServiceImpl studentService){
        this.studentService = studentService;
    }

    // Busca todos
    @GetMapping (value = "students")
    public List<Student> getStudents(){
        return studentService.findAllStudents();
    }

    // Busca 1 por id
    @GetMapping(value = "/student/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    // agrega
    @PostMapping(value = "/student/add")
    public Student addStudent(Student student){
        return studentService.saveStudent(student);
    }

    // Borra
    @DeleteMapping (value = "/student/delete/{id}")
    public String deletStudent(@PathVariable Long id){
        return studentService.deletStudent(id);
    }

    // actualiza
    @PutMapping(value = "/student/update")
    public String updateStudent(Student studentNew){
        return studentService.updateStudent(studentNew);
    }

}
