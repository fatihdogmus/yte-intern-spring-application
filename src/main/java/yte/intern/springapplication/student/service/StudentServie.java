package yte.intern.springapplication.student.service;

import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.common.enums.MessageType;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

@Service
public class StudentServie {

    private static final String STUDENT_ADDED_MESSAGE = "Student with student number %s has been added successfully";
    private static final String STUDENT_ALREADY_EXISTS_MESSAGE = "Student with student number %s already exists!";

    private final StudentRepository studentRepository;

    public StudentServie(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public MessageResponse addStudent(final Student newStudent) {
        if (studentRepository.existsByStudentNumber(newStudent.studentNumber())) {
            return new MessageResponse(MessageType.ERROR, studentAlreadyExistsMessage(newStudent.studentNumber()));
        }
        studentRepository.save(newStudent);
        return new MessageResponse(MessageType.SUCCESS, studentAddedMessage(newStudent.studentNumber()));
    }

    private String studentAlreadyExistsMessage(final String studentNumber) {
        return STUDENT_ALREADY_EXISTS_MESSAGE.formatted(studentNumber);
    }

    private String studentAddedMessage(final String studentNumber) {
        return STUDENT_ADDED_MESSAGE.formatted(studentNumber);
    }
}
