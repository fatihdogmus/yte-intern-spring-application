package yte.intern.springapplication.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.ResultType;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);

        return new MessageResponse("Student has been addedd successfully", ResultType.SUCCESS);
    }
}
