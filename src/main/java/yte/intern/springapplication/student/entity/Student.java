package yte.intern.springapplication.student.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.book.entity.Book;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String tcKimlikNo;
    private String studentNumber;

    public Student(String name, String surname, String email, String tcKimlikNo, String studentNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tcKimlikNo = tcKimlikNo;
        this.studentNumber = studentNumber;
    }

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Book> books = new ArrayList<>();
}
