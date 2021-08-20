package yte.intern.springapplication.student.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.student.controller.request.AddStudentRequest;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.service.StudentService;

import javax.validation.Valid;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public void addStudent(@Valid @RequestBody AddStudentRequest addStudentRequest) {
        Student student = addStudentRequest.toEntity();
        studentService.addStudent(student);
    }
}
