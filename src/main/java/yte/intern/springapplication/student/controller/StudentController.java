package yte.intern.springapplication.student.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @PostMapping
    public void addStudent(@RequestBody @Valid AddStudentRequest request) {

    }

}
