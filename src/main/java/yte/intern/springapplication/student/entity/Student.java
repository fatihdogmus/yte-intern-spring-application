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
}
