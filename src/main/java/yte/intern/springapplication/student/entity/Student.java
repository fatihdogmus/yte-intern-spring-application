package yte.intern.springapplication.student.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String tcKimlikNumber;
    private String studentNumber;

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
