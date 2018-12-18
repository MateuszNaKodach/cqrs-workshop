package io.github.nowakprojects.cqrsworkshop.withoutcqrs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Opinion {

    @Id
    private String id;

    private String author;
    private String content;
    private Integer rating;
    private Instant createDate;

    @Version
    private Long version;

    public Opinion(String author, String content, Integer rating) {
        this.author = author;
        this.content = content;
        this.rating = rating;
        this.id = UUID.randomUUID().toString();
        this.createDate = Instant.now();
    }

    //FIXME: Only for read
    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    //FIXME: Only for read
    public String getContent() {
        return content;
    }

    //FIXME: Only for read
    public Integer getRating() {
        return rating;
    }

    //FIXME: Only for read
    public Instant getCreateDate() {
        return createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opinion opinion = (Opinion) o;
        return Objects.equals(id, opinion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private Opinion(){

    }
}
