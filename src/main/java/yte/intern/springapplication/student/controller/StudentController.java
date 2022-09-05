package yte.intern.springapplication.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.student.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public MessageResponse addStudent(@RequestBody @Valid AddStudentRequest request) {
        return studentService.addStudent(request.toEntity());
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(StudentResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return StudentResponse.fromEntity(studentService.getStudentById(id));
    }

}
