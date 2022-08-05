package yte.intern.springapplication.student.controller.requests;

import yte.intern.springapplication.common.validators.TcKimlikNo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddStudenRequest(
        @NotBlank
        @Max(25)
        String name,
        @NotBlank
        @Max(25)
        String surname,
        @Email
        String email,
        @TcKimlikNo
        String tcKimlikNo,
        @NotBlank
        @Size(min = 7, max = 7)
        String studentNumber
) {
}
