package com.devdro.backend.service;

import com.devdro.backend.exeption.ExistingEmailException;
import com.devdro.backend.exeption.MinimumAgeException;
import com.devdro.backend.exeption.StudentNotFoundException;
import com.devdro.backend.model.Student;

public interface StudentService {

  Student create(Student student) throws ExistingEmailException, MinimumAgeException;

  Student findStudent(Long id) throws StudentNotFoundException;

  Student findStudent(String email) throws StudentNotFoundException;
}
