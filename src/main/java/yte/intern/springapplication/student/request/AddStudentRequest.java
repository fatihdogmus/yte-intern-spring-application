package yte.intern.springapplication.student.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.intern.springapplication.student.entity.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Getter
@ToString
public class AddStudentRequest {

    @Size(max = 255, message = "First name can't exceed 255 characters")
    @NotEmpty(message = "First name can't be empty")
    private final String firstName;

    @Size(max = 255, message = "Last name can't exceed 255 characters")
    @NotEmpty(message = "Last name can't be empty")
    private final String lastName;

    @Email(message = "Please enter a valid e-mail address")
    @NotEmpty(message = "E-mail can't be empty")
    private final String email;

    @Size(min = 11, max = 11, message = "TC Kimlik number must be 11 characters long")
    private final String tcKimlikNumber;

    @Size(min = 7, max = 7, message = "Student number must be 7 characters long")
    private final String studentNumber;

    public Student toStudent() {
        return new Student(firstName, lastName, email, tcKimlikNumber, studentNumber);
    }
}
