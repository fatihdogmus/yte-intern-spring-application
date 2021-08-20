package yte.intern.springapplication.student.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate publishDate;
    private Integer pageCount;

    public Book(final String name,
                final LocalDate publishDate,
                final Integer pageCount) {
        this.name = name;
        this.publishDate = publishDate;
        this.pageCount = pageCount;
    }
}
