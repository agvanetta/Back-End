package com.example.demo.service;

import com.example.demo.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    IStudentService studentService;

    @Test
    public void testGetStudentsWithLastnameLike(){

        StudentDTO student = new StudentDTO();
        student.setLastname("Milito");
        student.setName("Diego Alberto");

        studentService.createStudent(student);
        Set<StudentDTO> students = studentService.getStudentsWithLastnameLike("Milito");

        boolean resultado = students.size() > 0;

        assertTrue(resultado);
    }
}