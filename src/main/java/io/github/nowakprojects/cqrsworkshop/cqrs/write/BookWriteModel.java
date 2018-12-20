package io.github.nowakprojects.cqrsworkshop.cqrs.write;


import io.github.nowakprojects.cqrsworkshop.cqrs.event.BookCreated;
import io.github.nowakprojects.cqrsworkshop.cqrs.event.BookOpinionAdded;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(schema = "cqrs")
@Entity
public class BookWriteModel extends AbstractAggregateRoot<BookWriteModel> {

    @Id
    private String id;

    @NotBlank
    private String title;

    private String author;

    private String genre;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OpinionWriteModel> opinions = new ArrayList<>();

    @Version
    private Long version;

    public BookWriteModel(@NotBlank String title, String author, String genre) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.genre = genre;
        registerEvent(new BookCreated(id, title, author, genre));
    }

    public void addOpinion(OpinionWriteModel opinion) {
        if (opinions.stream().noneMatch(it -> it.getAuthor().equals(opinion.getAuthor()))) {
            opinions.add(opinion);
            registerEvent(new BookOpinionAdded(id, opinion.getId(), opinion.getAuthor(), opinion.getContent(), opinion.getRating(), opinion.getCreateDate()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookWriteModel book = (BookWriteModel) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private BookWriteModel() {
    }
}
