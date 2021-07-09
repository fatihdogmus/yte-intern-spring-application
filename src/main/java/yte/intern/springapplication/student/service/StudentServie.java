package yte.intern.springapplication.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.common.enums.MessageType;
import yte.intern.springapplication.student.entity.Book;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class StudentServie {

    private static final String STUDENT_ADDED_MESSAGE = "Student with student number %s has been added successfully";
    private static final String STUDENT_ALREADY_EXISTS_MESSAGE = "Student with student number %s already exists!";
    private static final String STUDENT_DOESNT_EXIST_MESSAGE = "Student with student number %s doesn't exists!";
    private static final String STUDENT_DOESNT_EXIST_ID_MESSAGE = "Student with student id %s doesn't exists!";
    private static final String STUDENT_UPDATED_MESSAGE = "Student with id %s has been updated successfully!";
    private static final String STUDENT_DELETED_MESSAGE = "Student with id %s has beeen deleted successfully!";

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

    public Student getStudentByStudentNumber(final String studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new EntityNotFoundException(STUDENT_DOESNT_EXIST_MESSAGE.formatted(studentNumber)));
    }

    public MessageResponse updateStudent(final Long id, final Student updatedStudent) {
        Student studentFromDB = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(STUDENT_DOESNT_EXIST_MESSAGE.formatted(updatedStudent.studentNumber())));
        studentFromDB.updateStudent(updatedStudent);
        studentRepository.save(studentFromDB);
        return new MessageResponse(MessageType.SUCCESS, STUDENT_UPDATED_MESSAGE.formatted(id));
    }

    public MessageResponse deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return new MessageResponse(MessageType.ERROR, STUDENT_DOESNT_EXIST_ID_MESSAGE.formatted(id));
        }
        studentRepository.deleteById(id);

        return new MessageResponse(MessageType.SUCCESS, STUDENT_DELETED_MESSAGE.formatted(id));
    }

    @Transactional
    public MessageResponse addBookToStudent(Long id, Book book) {
        Student studentFromDB = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(STUDENT_DOESNT_EXIST_ID_MESSAGE.formatted(id)));

        MessageResponse response = studentFromDB.canAddBook(book);
        if (response.hasError()) {
            return response;
        }
        studentFromDB.addBook(book);
        studentRepository.save(studentFromDB);

        return new MessageResponse(MessageType.SUCCESS, "Book %s has been added to student!".formatted(book.name()));

    }
}
