package yte.intern.springapplication.student.controller.response;

import lombok.Getter;
import yte.intern.springapplication.student.entity.Student;

@Getter
public class StudentQueryResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String tcKimlikNumber;
    private final String studentNumber;

    public StudentQueryResponse(final Student student) {
        this.id = student.id();
        this.firstName = student.firstName();
        this.lastName = student.lastName();
        this.email = student.email();
        this.tcKimlikNumber = student.tcKimlikNumber();
        this.studentNumber = student.studentNumber();
    }
}
