package yte.intern.springapplication.student.controller;

import yte.intern.springapplication.common.validation.TcKimlikNo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record AddStudentRequest(

        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String surname,
        @TcKimlikNo
        String tcKimlikNo,
        @Email
        @Size(max = 255)
        String email,
        @NotEmpty
        @Size(min = 7, max = 7)
        String studentNumber

) {
}
