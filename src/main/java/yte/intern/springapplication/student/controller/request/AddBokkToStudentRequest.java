package yte.intern.springapplication.student.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yte.intern.springapplication.student.entity.Book;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class AddBokkToStudentRequest {

    private final String name;
    private final LocalDate publishDate;
    private final Integer pageCount;

    public Book toEntity() {
        return new Book(name, publishDate, pageCount);
    }
}
