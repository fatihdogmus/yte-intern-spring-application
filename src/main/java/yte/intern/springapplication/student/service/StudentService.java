package yte.intern.springapplication.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.ResultType;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);

        return new MessageResponse("Student has been addedd successfully", ResultType.SUCCESS);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID %d not found".formatted(id)));
    }

    public MessageResponse updateStudent(Long id, Student newStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.update(newStudent);
        studentRepository.save(existingStudent);
        return new MessageResponse("Student with id %d has been updated".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return new MessageResponse("Student with id %d has been deleted", ResultType.SUCCESS);
    }
}
