package yte.intern.springapplication.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
