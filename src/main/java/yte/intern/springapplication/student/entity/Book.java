package yte.intern.springapplication.student.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Book extends BaseEntity {

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

    public boolean hasSameNameAs(Book toBeAddedBook) {
        return name.equals(toBeAddedBook.name);
    }
}
