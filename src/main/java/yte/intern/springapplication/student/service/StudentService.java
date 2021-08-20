package yte.intern.springapplication.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.common.dto.MessageType;
import yte.intern.springapplication.student.entity.Book;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);
        return new MessageResponse("Student has been saved successfully!", MessageType.SUCCESS);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public MessageResponse updateStudent(Long id, Student newStudent) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id %s is not found".formatted(id)));
        student.updateStudent(newStudent);
        studentRepository.save(student);

        return new MessageResponse("Student with id %s has been updated successfully!".formatted(id), MessageType.SUCCESS);
    }

    public MessageResponse deleteStudent(Long id) {
        studentRepository.deleteById(id);

        return new MessageResponse("Student with id %s has been deleted successfully!", MessageType.SUCCESS);
    }

    @Transactional
    public MessageResponse addBookToStudent(Long id, Book toBeAddedBook) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id %s is not found".formatted(id)));
        MessageResponse messageResponse = student.canAddBook(toBeAddedBook);
        if (messageResponse.hasError()) {
            return messageResponse;
        }
        student.addBook(toBeAddedBook);

        return new MessageResponse("Book %s has been added successfully!".formatted(toBeAddedBook.getName()), MessageType.SUCCESS);
    }
}
