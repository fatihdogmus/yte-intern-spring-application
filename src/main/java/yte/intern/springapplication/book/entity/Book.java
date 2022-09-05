package yte.intern.springapplication.book.entity;

import lombok.Getter;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
public class Book extends BaseEntity {

    private String name;
    private LocalDate publishDate;
    private Integer pageCount;
}
