package io.github.nowakprojects.cqrsworkshop.cqrs.event;

import java.time.Instant;

public class BookOpinionAdded extends DomainEvent {

    private final String bookId;
    private final String opinionId;
    private final String author;
    private final String content;
    private final Integer rating;
    private final Instant createDate;


    public BookOpinionAdded(String bookId, String opinionId, String author, String content, Integer rating, Instant createDate) {
        super();
        this.bookId = bookId;
        this.opinionId = opinionId;
        this.author = author;
        this.content = content;
        this.rating = rating;
        this.createDate = createDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOpinionId() {
        return opinionId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Integer getRating() {
        return rating;
    }

    public Instant getCreateDate() {
        return createDate;
    }
}
