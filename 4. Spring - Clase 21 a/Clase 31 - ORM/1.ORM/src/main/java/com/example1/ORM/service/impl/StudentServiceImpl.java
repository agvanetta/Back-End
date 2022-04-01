package com.example1.ORM.service.impl;

import com.example1.ORM.entity.Student;
import com.example1.ORM.repository.IStudentRepository;
import com.example1.ORM.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student studentNew) {
        if (studentNew != null) {
            return studentRepository.save(studentNew);
        }
        return new Student();
    }

    @Override
    public String deletStudent(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
            return "Student with id" + id + " delete";
        }
        return "Student with id " + id + " dont exist";
    }

    @Override
    public String updateStudent(Student studentNew) {
        Student existingProduct = studentRepository.findById(studentNew.getId()).orElse(null);
        existingProduct.setName(existingProduct.getName());
        existingProduct.setDni(existingProduct.getDni());
        existingProduct.setLastname(existingProduct.getLastname());
        studentRepository.save(existingProduct);
        return "Actualizado id: " + existingProduct.getId() + "name&lastname " + existingProduct.getName() + existingProduct.getLastname();
    }
}
