package io.github.nowakprojects.cqrsworkshop.withoutcqrs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
