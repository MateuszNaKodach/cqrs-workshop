package io.github.nowakprojects.cqrsworkshop.cqrs.event;

public class BookCreated extends DomainEvent {

    private final String bookId;
    private final String title;
    private final String author;
    private final String genre;

    public BookCreated(String bookId, String title, String author, String genre) {
        super();
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
