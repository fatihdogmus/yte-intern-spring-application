package yte.intern.springapplication.student.controller;

import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.student.controller.request.AddStudentRequest;
import yte.intern.springapplication.student.controller.request.UpdateStudentRequest;
import yte.intern.springapplication.student.controller.response.StudentQueryResponse;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentQueryResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(student -> new StudentQueryResponse(student))
                .toList();
    }

    @PostMapping
    public MessageResponse addStudent(@Valid @RequestBody final AddStudentRequest addStudentRequest) {
        Student student = addStudentRequest.toEntity();
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public MessageResponse updateStudent(@PathVariable final Long id, @Valid @RequestBody final UpdateStudentRequest updateStudentRequest) {
        return studentService.updateStudent(id, updateStudentRequest.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
