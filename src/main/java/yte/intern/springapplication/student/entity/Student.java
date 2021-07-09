package yte.intern.springapplication.student.entity;

import lombok.Getter;
import lombok.experimental.Accessors;
import yte.intern.springapplication.common.dto.MessageResponse;
import yte.intern.springapplication.common.entity.BaseEntity;
import yte.intern.springapplication.common.enums.MessageType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Accessors(fluent = true)
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String tcKimlikNumber;
    private String studentNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set<Book> books = new HashSet<>();

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

        Book algorithmBook = new Book("Introduction to algorithms", LocalDate.parse("1989-01-01"), 1312);
        books.add(algorithmBook);
    }

    public void updateStudent(final Student updatedStudent) {
        this.firstName = updatedStudent.firstName;
        this.lastName = updatedStudent.lastName;
        this.email = updatedStudent.email;
        this.tcKimlikNumber = updatedStudent.tcKimlikNumber;
        this.studentNumber = updatedStudent.studentNumber;
    }

    public MessageResponse canAddBook(final Book toBeAddedBook) {
        if (hasSameBook(toBeAddedBook)) {
            return new MessageResponse(MessageType.ERROR, "Student has already the book %s".formatted(toBeAddedBook.name()));
        }
        return new MessageResponse(MessageType.SUCCESS, "");
    }

    private boolean hasSameBook(final Book toBeAddedBook) {
        return books.stream()
                .anyMatch(toBeAddedBook::hasSameNameAs);
    }

    public void addBook(final Book toBeAddedBook) {
        if (canAddBook(toBeAddedBook).hasError()) {
            throw new IllegalStateException();
        }
        books.add(toBeAddedBook);
    }
}
