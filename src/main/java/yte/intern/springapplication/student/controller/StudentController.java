package yte.intern.springapplication.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.student.controller.requests.AddStudentRequest;
import yte.intern.springapplication.student.service.StudentService;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody AddStudentRequest addStudentRequest) {
        studentService.addStudent(addStudentRequest.toDomainEntity());
    }
}
