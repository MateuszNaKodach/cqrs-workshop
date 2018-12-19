package io.github.nowakprojects.cqrsworkshop.rest;

import io.github.nowakprojects.cqrsworkshop.rest.dto.BookDto;
import io.github.nowakprojects.cqrsworkshop.withoutcqrs.BookRepository;
import io.github.nowakprojects.cqrsworkshop.withoutcqrs.DataBootstrap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/cqrs/books")
public class BookCqrsController {

    private final BookRepository bookRepository;
    private final DataBootstrap dataBootstrap;

    public BookCqrsController(BookRepository bookRepository, DataBootstrap dataBootstrap) {
        this.bookRepository = bookRepository;
        this.dataBootstrap = dataBootstrap;
    }

    @GetMapping("load-fake")
    String loadFakeBooks() {
        dataBootstrap.loadFakeBooks();
        return "Books loaded";
    }

    @GetMapping
    Collection<BookDto> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }

}
