package io.github.nowakprojects.cqrsworkshop.withoutcqrs;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BookDto {
    private String id;
    private String title;
    private Double averageRating;
    private SortedSet<OpinionDto> opinions;

    private BookDto(String id, String title, Double averageRating, SortedSet<OpinionDto> opinions) {
        this.id = id;
        this.title = title;
        this.averageRating = averageRating;
        this.opinions = opinions;
    }

    public static BookDto from(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAverageRating(),
                book.getOpinions()
                        .stream()
                        .map(OpinionDto::from)
                        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(OpinionDto::getRating, Comparator.naturalOrder()))))
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

    public SortedSet<OpinionDto> getOpinions() {
        return opinions;
    }
}
