package yte.intern.springapplication.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.student.controller.requests.AddStudentRequest;
import yte.intern.springapplication.student.controller.responses.StudentQueryModel;
import yte.intern.springapplication.student.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public MessageResponse addStudent(@Valid @RequestBody AddStudentRequest addStudentRequest) {
        return studentService.addStudent(addStudentRequest.toDomainEntity());
    }

    @GetMapping
    public List<StudentQueryModel> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(student -> new StudentQueryModel(student))
                .toList();
    }

    @GetMapping("/{id}")
    public StudentQueryModel getById(@PathVariable Long id) {
        return new StudentQueryModel(studentService.getById(id));
    }
}
