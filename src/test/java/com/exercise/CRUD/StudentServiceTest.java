package com.exercise.CRUD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceTest {
    private StudentService studentService;
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void createStudent(){
        Student studentToInsert = new Student(0L,"Gianni", "Rossi",true);
        Student studentToReturn = new Student(1L,"Gianni", "Rossi",true);
        when(studentRepository.save(studentToInsert)).thenReturn(studentToReturn);
        Student returnedStudent = studentService.createStudent(studentToInsert);
        assertEquals(studentToReturn,returnedStudent);
    }
    @Test
    void createStudentException(){
        when(studentRepository.save(new Student())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> studentService.createStudent(new Student()));
    }
}
