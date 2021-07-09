package yte.intern.springapplication.student.entity;

import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String tcKimlikNumber;
    private String studentNumber;

    protected Student() {
    }

    public Student(final String firstName,
                   final String lastName,
                   final String email,
                   final String tcKimlikNumber,
                   final String studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tcKimlikNumber = tcKimlikNumber;
        this.studentNumber = studentNumber;
    }
}
