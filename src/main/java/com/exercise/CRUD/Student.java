package com.exercise.CRUD;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
@GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private boolean isWorking;
    public Student(String name, String surname, boolean isWorking) {}
}

