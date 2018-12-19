package io.github.nowakprojects.cqrsworkshop.rest.dto;

import io.github.nowakprojects.cqrsworkshop.withoutcqrs.Book;

public class BookDto {
    private String id;
    private String title;
    private Integer ratingsCount;
    private Double averageRating;
    private OpinionDto lastOpinion;

    private BookDto(String id, String title, Integer ratingsCount, Double averageRating, OpinionDto lastOpinion) {
        this.id = id;
        this.title = title;
        this.ratingsCount = ratingsCount;
        this.averageRating = averageRating;
        this.lastOpinion = lastOpinion;
    }

    public static BookDto from(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
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
