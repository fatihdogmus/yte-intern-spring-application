package yte.intern.springapplication.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.student.service.StudentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public MessageResponse addStudent(@RequestBody @Valid AddStudentRequest request) {
        return studentService.addStudent(request.toEntity());
    }

}
