package yte.intern.springapplication.student.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.student.controller.request.AddStudentRequest;
import yte.intern.springapplication.student.controller.response.StudentQueryResponse;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.service.StudentServie;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {

    private final StudentServie studentServie;

    public StudentController(final StudentServie studentServie) {
        this.studentServie = studentServie;
    }

    @PostMapping
    public MessageResponse addStudent(@Valid @RequestBody final AddStudentRequest request) {
        return studentServie.addStudent(request.toStudent());
    }

    @GetMapping("/{studentNumber}")
    public StudentQueryResponse getStudentByStudentNumber(
            @PathVariable
            @Size(min = 7, max = 7, message = "Student number must be 7 characters long") final String studentNumber) {
        Student student = studentServie.getStudentByStudentNumber(studentNumber);
        return new StudentQueryResponse(student);
    }
}
