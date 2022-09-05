package yte.intern.springapplication.student.entity;

import lombok.Getter;
import yte.intern.springapplication.book.entity.Book;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String tcKimlikNo;
    private String studentNumber;

    @OneToMany
    private List<Book> books = new ArrayList<>();
}
