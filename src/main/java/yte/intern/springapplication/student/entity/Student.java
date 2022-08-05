package yte.intern.springapplication.student.entity;

import lombok.Getter;
import yte.intern.springapplication.book.entity.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String tcKimlikNo;
    private String studentNumber;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Book> books = new HashSet<>();
}
