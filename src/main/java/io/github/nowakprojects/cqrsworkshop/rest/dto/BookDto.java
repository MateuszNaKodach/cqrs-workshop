package io.github.nowakprojects.cqrsworkshop.rest.dto;

import io.github.nowakprojects.cqrsworkshop.withoutcqrs.Book;

public class BookDto {
    private String id;
    private String title;
    private String author;
    private String genre;
    private Integer ratingsCount;
    private Double averageRating;
    private OpinionDto lastOpinion;

    public BookDto(String id, String title, String author, String genre, Integer ratingsCount, Double averageRating, OpinionDto lastOpinion) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ratingsCount = ratingsCount;
        this.averageRating = averageRating;
        this.lastOpinion = lastOpinion;
    }

    public static BookDto from(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getRatingsCount(),
                book.getAverageRating(),
                OpinionDto.from(book.getLastOpinion())
        );
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public OpinionDto getLastOpinion() {
        return lastOpinion;
    }
}
