package yte.intern.springapplication.student.entity;

import lombok.Getter;
import yte.intern.springapplication.book.entity.Book;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String tcKimlikNo;
    private String studentNumber;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Book> books = new HashSet<>();
}
