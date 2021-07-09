package yte.intern.springapplication.student.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yte.intern.springapplication.student.entity.Book;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class AddBookToStudentRequest {

    @NotBlank
    private final String name;
    @PastOrPresent
    private final LocalDate publishDate;
    @Min(value = 1)
    private final int pageCount;

    public Book toBook() {
        return new Book(name, publishDate, pageCount);
    }
}
