package io.github.nowakprojects.cqrsworkshop.cqrs;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import io.github.nowakprojects.cqrsworkshop.cqrs.write.BookWriteModel;
import io.github.nowakprojects.cqrsworkshop.cqrs.write.BookWriteModelRepository;
import io.github.nowakprojects.cqrsworkshop.cqrs.write.OpinionWriteModel;
import io.github.nowakprojects.cqrsworkshop.withoutcqrs.BookRepository;
import io.github.nowakprojects.cqrsworkshop.withoutcqrs.Opinion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

import static io.github.nowakprojects.cqrsworkshop.ExampleConstants.BOOKS_COUNT;
import static io.github.nowakprojects.cqrsworkshop.ExampleConstants.OPINIONS_PER_BOOK_COUNT;

@Component
public class CqrsDataBootstrap {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final BookWriteModelRepository bookRepository;
    private final Faker faker = new Faker(Locale.ENGLISH);
    private final Random random = new Random();

    public CqrsDataBootstrap(BookWriteModelRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void loadFakeBooks() {
        log.info("Start loading fake books");
        for (int i = 0; i < BOOKS_COUNT; i++) {
            BookWriteModel book = generateBook();
            bookRepository.save(book);
        }
        log.info("Finish loading fake books");
    }

    private BookWriteModel generateBook() {
        Book fakeBook = faker.book();
        BookWriteModel book = new BookWriteModel(
                fakeBook.title(),
                fakeBook.author(),
                fakeBook.genre()
        );

        for (int j = 0; j < OPINIONS_PER_BOOK_COUNT; j++) {
            book.addOpinion(new OpinionWriteModel("Author" + j, faker.chuckNorris().fact(), random.nextInt(10) + 1));
        }
        return book;
    }

    @Async
    public void addBookAsync() throws InterruptedException {
        Thread.sleep(4000);
        bookRepository.save(generateBook());
    }
}
