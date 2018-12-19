package io.github.nowakprojects.cqrsworkshop.cqrs.write;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Table(schema = "cqrs")
@Entity
public class OpinionWriteModel {

    @Id
    private String id;

    private String author;
    private String content;
    private Integer rating;
    private Instant createDate;

    @Version
    private Long version;

    public OpinionWriteModel(String author, String content, Integer rating) {
        this.author = author;
        this.content = content;
        this.rating = rating;
        this.id = UUID.randomUUID().toString();
        this.createDate = Instant.now();
    }

    String getId() {
        return id;
    }

    String getAuthor() {
        return author;
    }

    String getContent() {
        return content;
    }

    Integer getRating() {
        return rating;
    }

    Instant getCreateDate() {
        return createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpinionWriteModel opinion = (OpinionWriteModel) o;
        return Objects.equals(id, opinion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private OpinionWriteModel() {

    }
}
