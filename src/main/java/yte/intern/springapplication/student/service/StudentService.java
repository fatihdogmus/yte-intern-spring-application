package yte.intern.springapplication.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.MessageType;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);

        return new MessageResponse("Student has been addedd successfully", MessageType.SUCCESS);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID %d not found".formatted(id)));
    }

    @Transactional
    public MessageResponse updateStudent(Long id, Student newStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.update(newStudent);
        studentRepository.save(existingStudent);
        return new MessageResponse("Student with id %d has been updated".formatted(id), MessageType.SUCCESS);
    }

    public MessageResponse deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return new MessageResponse("Student can't be found", MessageType.ERROR);
        }
        studentRepository.deleteById(id);
        return new MessageResponse("Student has been deleted successfully", MessageType.SUCCESS);

    }
}
