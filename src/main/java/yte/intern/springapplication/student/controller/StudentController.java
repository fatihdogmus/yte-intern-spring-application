package yte.intern.springapplication.student.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.student.request.AddStudentRequest;
import yte.intern.springapplication.student.service.StudentServie;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServie studentServie;

    public StudentController(final StudentServie studentServie) {
        this.studentServie = studentServie;
    }

    @PostMapping
    public MessageResponse addStudent(@Valid @RequestBody final AddStudentRequest request) {
        return studentServie.addStudent(request.toStudent());
    }
}
