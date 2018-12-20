package io.github.nowakprojects.cqrsworkshop.rest.dto;

import io.github.nowakprojects.cqrsworkshop.withoutcqrs.Opinion;

import java.time.Instant;

public class OpinionDto {

    private String id;

    private String author;
    private String content;
    private Integer rating;
    private Instant createDate;

    private OpinionDto(String id, String author, String content, Integer rating, Instant createDate) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.rating = rating;
        this.createDate = createDate;
    }

    static OpinionDto from(Opinion opinion) {
        return new OpinionDto(
                opinion.getId(),
                opinion.getAuthor(),
                opinion.getContent(),
                opinion.getRating(),
                opinion.getCreateDate()
        );
    }

    public String getId() {
        return id;
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
