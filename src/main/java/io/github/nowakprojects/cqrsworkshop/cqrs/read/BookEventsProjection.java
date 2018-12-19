package io.github.nowakprojects.cqrsworkshop.cqrs.read;

import io.github.nowakprojects.cqrsworkshop.cqrs.event.BookCreated;
import io.github.nowakprojects.cqrsworkshop.cqrs.event.BookOpinionAdded;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Optional;

@Component
public class BookEventsProjection {

    private final BookReadModelRepository repository;

    public BookEventsProjection(BookReadModelRepository repository) {
        this.repository = repository;
    }

    @TransactionalEventListener
    public void eventProjection(BookCreated event) {
        final Optional<BookReadModel> bookById = repository.findById(event.getBookId());
        if (bookById.isPresent()) {
            BookReadModel book = bookById.get();
            book.process(event);
            repository.save(book);
        } else {
            repository.save(BookReadModel.from(event));
        }
    }

    @TransactionalEventListener
    public void eventProjection(BookOpinionAdded event) {
        final Optional<BookReadModel> bookById = repository.findById(event.getBookId());
        if (bookById.isPresent()) {
            BookReadModel book = bookById.get();
            book.process(event);
            repository.save(book);
        } else {
            repository.save(BookReadModel.from(event));
        }
    }

}
