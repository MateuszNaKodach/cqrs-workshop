package io.github.nowakprojects.cqrsworkshop.rest;

import io.github.nowakprojects.cqrsworkshop.cqrs.CqrsDataBootstrap;
import io.github.nowakprojects.cqrsworkshop.cqrs.event.DomainEvent;
import io.github.nowakprojects.cqrsworkshop.cqrs.read.BookReadModel;
import io.github.nowakprojects.cqrsworkshop.cqrs.read.BookReadModelRepository;
import io.github.nowakprojects.cqrsworkshop.cqrs.read.ObservableDomainEventStream;
import io.github.nowakprojects.cqrsworkshop.cqrs.write.BookWriteModel;
import io.github.nowakprojects.cqrsworkshop.cqrs.write.BookWriteModelRepository;
import io.github.nowakprojects.cqrsworkshop.rest.dto.BookDto;
import io.github.nowakprojects.cqrsworkshop.withoutcqrs.BookRepository;
import io.github.nowakprojects.cqrsworkshop.withoutcqrs.DataBootstrap;
import io.reactivex.Flowable;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@EnableAsync
@CrossOrigin
@RestController
@RequestMapping("/cqrs/books")
public class BookCqrsController {

    private final BookReadModelRepository bookRepository;
    private final BookWriteModelRepository bookWriteModelRepository;
    private final CqrsDataBootstrap cqrsDataBootstrap;
    private final ObservableDomainEventStream observableDomainEventStream;

    public BookCqrsController(
            BookReadModelRepository bookRepository,
            BookWriteModelRepository bookWriteModelRepository,
            CqrsDataBootstrap cqrsDataBootstrap,
            ObservableDomainEventStream observableDomainEventStream
    ) {
        this.bookRepository = bookRepository;
        this.bookWriteModelRepository = bookWriteModelRepository;
        this.cqrsDataBootstrap = cqrsDataBootstrap;
        this.observableDomainEventStream = observableDomainEventStream;
    }

    @GetMapping
    Collection<BookReadModel> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    void addFakeBook() throws InterruptedException {
        cqrsDataBootstrap.addBookAsync();
    }


    @GetMapping(value = "event-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flowable<DomainEvent> getDomainEventStream() {
        return observableDomainEventStream.eventStream();
    }

    @GetMapping("load-fake")
    String loadFakeBooks() {
        cqrsDataBootstrap.loadFakeBooks();
        return "Books loaded";
    }

}
