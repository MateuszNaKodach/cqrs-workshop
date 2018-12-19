package io.github.nowakprojects.cqrsworkshop.cqrs.read;

import java.time.Instant;

public class OpinionReadModel {
    private final String opinionId;
    private final String author;
    private final String content;
    private final Integer rating;
    private final Instant createDate;

    public OpinionReadModel(String opinionId, String author, String content, Integer rating, Instant createDate) {
        this.opinionId = opinionId;
        this.author = author;
        this.content = content;
        this.rating = rating;
        this.createDate = createDate;
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
