package io.github.nowakprojects.cqrsworkshop.withoutcqrs;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
public class Book {

    @Id
    private String id;

    @NotBlank
    private String title;

    private String author;

    private String genre;

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Opinion> opinions = new ArrayList<>();

    @Version
    private Long version;

    public Book(@NotBlank String title, String author, String genre) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.genre = genre;
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

    public Integer getRatingsCount() {
        return opinions.size();
    }

    //FIXME: Is only for reading purpose
    public Double getAverageRating() {
        return opinions.stream()
                .mapToInt(Opinion::getRating)
                .average().orElse(0);
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    //FIXME: Is only for reading purpose
    /*public List<OpinionWriteModel> getOpinions() {
        return opinions;
    }*/

    //FIXME: Is only for reading purpose
    public Opinion getLastOpinion(){
        return opinions.stream().skip(opinions.size() - 1).findFirst().orElse(null);
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
