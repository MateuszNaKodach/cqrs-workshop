package io.github.nowakprojects.cqrsworkshop.withoutcqrs;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Book {

    @Id
    private String id;

    @NotBlank
    private String title;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Opinion> opinions = new ArrayList<>();

    @Version
    private Long version;

    public Book(@NotBlank String title) {
        this.title = title;
        this.id = UUID.randomUUID().toString();
    }

    //FIXME: Is only for reading purpose
    public String getId() {
        return id;
    }

    //FIXME: Is only for reading purpose
    public String getTitle() {
        return title;
    }

    public void addOpinion(Opinion opinion) {
        if (opinions.stream().noneMatch(it -> it.getAuthor().equals(opinion.getAuthor()))) {
            opinions.add(opinion);
        }
    }

    //FIXME: Is only for reading purpose
    public Double getAverageRating() {
        return opinions.stream()
                .mapToInt(Opinion::getRating)
                .average().orElse(0);
    }

    //FIXME: Is only for reading purpose
    public List<Opinion> getOpinions() {
        return opinions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private Book() {
    }
}
