package yte.intern.springapplication.student.controller.requests;

import yte.intern.springapplication.student.entity.Student;

public record UpdateStudentRequest(
        String name,
        String surname,
        String email
) {

    public Student toDomainEntity() {
        return new Student(name, surname, email, null, null);
    }
}
