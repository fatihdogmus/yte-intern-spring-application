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

    public StudentQueryResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.tcKimlikNumber = student.getTcKimlikNumber();
        this.studentNumber = student.getStudentNumber();
    }
}
