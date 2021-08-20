package yte.intern.springapplication.student.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yte.intern.springapplication.student.entity.Student;

@Getter
@RequiredArgsConstructor
public class UpdateStudentRequest {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String tcKimlikNumber;
    private final String studentNumber;

    public Student toEntity() {
        return new Student(firstName, lastName, email, tcKimlikNumber, studentNumber);
    }
}
