package io.github.nowakprojects.cqrsworkshop.rest;

import io.github.nowakprojects.cqrsworkshop.cqrs.CqrsDataBootstrap;
import io.github.nowakprojects.cqrsworkshop.cqrs.read.BookReadModel;
import io.github.nowakprojects.cqrsworkshop.cqrs.read.BookReadModelRepository;
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

    private final BookReadModelRepository bookRepository;
    private final CqrsDataBootstrap cqrsDataBootstrap;

    public BookCqrsController(BookReadModelRepository bookRepository, CqrsDataBootstrap cqrsDataBootstrap) {
        this.bookRepository = bookRepository;
        this.cqrsDataBootstrap = cqrsDataBootstrap;
    }

    @GetMapping
    Collection<BookReadModel> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("load-fake")
    String loadFakeBooks() {
        cqrsDataBootstrap.loadFakeBooks();
        return "Books loaded";
    }

}
