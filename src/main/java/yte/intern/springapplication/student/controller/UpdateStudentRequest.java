package yte.intern.springapplication.student.controller;

import yte.intern.springapplication.student.entity.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record UpdateStudentRequest(
        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String surname,
        @Email
        @Size(max = 255)
        String email,
        @NotEmpty
        @Size(min = 7, max = 7)
        String studentNumber
) {

    public Student toEntity() {
        return new Student(
                name,
                surname,
                email,
                null,
                studentNumber
        );
    }
}
