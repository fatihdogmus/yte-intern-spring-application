package yte.intern.springapplication.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.common.dto.MessageType;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

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
}
