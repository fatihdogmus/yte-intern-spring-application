package yte.intern.springapplication.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.student.controller.request.AddStudentRequest;
import yte.intern.springapplication.student.controller.response.StudentQueryResponse;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentQueryResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(student -> new StudentQueryResponse(student))
                .toList();
    }

    @PostMapping("/students")
    public MessageResponse addStudent(@Valid @RequestBody AddStudentRequest addStudentRequest) {
        Student student = addStudentRequest.toEntity();
        return studentService.addStudent(student);
    }
}
