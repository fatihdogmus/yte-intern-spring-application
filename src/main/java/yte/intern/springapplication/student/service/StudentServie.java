package yte.intern.springapplication.student.service;

import org.springframework.stereotype.Service;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

@Service
public class StudentServie {

    private final StudentRepository studentRepository;

    public StudentServie(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }
}
