package com.exercise.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student student;
        if (studentRepository.findById(id).isPresent()) student = studentRepository.findById(id).get();
        else throw new RuntimeException("Student not found with id " + id);
        student.setName(updatedStudent.getName());
        student.setSurname(updatedStudent.getSurname());
        return studentRepository.save(student);
    }

    public Student updateIsWorking(Long id, boolean isWorking) {
        Student student;
        if (studentRepository.findById(id).isPresent()) student = studentRepository.findById(id).get();
        else throw new RuntimeException("Student not found with id " + id);
        student.setWorking(isWorking);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
