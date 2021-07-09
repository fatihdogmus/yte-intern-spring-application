package yte.intern.springapplication.student.entity;

import lombok.Getter;
import lombok.experimental.Accessors;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Accessors(fluent = true)
public class Book extends BaseEntity {

    @Getter
    private String name;
    private LocalDate publishDate;
    private Integer pageCount;

    protected Book() {
    }

    public Book(final String name, final LocalDate publishDate, final Integer pageCount) {
        this.name = name;
        this.publishDate = publishDate;
        this.pageCount = pageCount;
    }

    public boolean hasSameNameAs(Book book) {
        return name.equals(book.name);
    }
}
