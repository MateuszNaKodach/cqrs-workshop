package io.github.nowakprojects.cqrsworkshop.cqrs.read;

import io.github.nowakprojects.cqrsworkshop.cqrs.event.BookCreated;
import io.github.nowakprojects.cqrsworkshop.cqrs.event.BookOpinionAdded;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookReadModel {

    @Id
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private OpinionReadModel lastOpinion;
    private Integer ratingsCount = 0;
    private Integer ratingsSum = 0;

    private BookReadModel(String bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    private BookReadModel(String bookId) {
        this.bookId = bookId;
    }

    public static BookReadModel from(BookCreated event) {
        return new BookReadModel(
                event.getBookId(),
                event.getTitle(),
                event.getAuthor(),
                event.getGenre()
        );
    }

    public static BookReadModel from(BookOpinionAdded event) {
        BookReadModel book = new BookReadModel(event.getBookId());
        book.process(event);
        return book;
    }

    public void process(BookCreated event) {
        this.title = event.getTitle();
        this.author = event.getAuthor();
        this.genre = event.getGenre();
    }

    public void process(BookOpinionAdded event) {
        OpinionReadModel opinion = new OpinionReadModel(event.getOpinionId(), event.getAuthor(), event.getContent(), event.getRating(), event.getCreateDate());
        addNewOpinion(opinion);
    }

    private void addNewOpinion(OpinionReadModel lastOpinion) {
        this.lastOpinion = lastOpinion;
        ratingsCount++;
        ratingsSum += lastOpinion.getRating();
    }

    public Double getAverageRating() {
        return ratingsSum.doubleValue() / ratingsCount.doubleValue();
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

    public OpinionReadModel getLastOpinion() {
        return lastOpinion;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    private BookReadModel() {
    }
}
