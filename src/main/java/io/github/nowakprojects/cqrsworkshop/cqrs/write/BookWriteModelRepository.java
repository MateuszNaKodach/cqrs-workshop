package io.github.nowakprojects.cqrsworkshop.cqrs.write;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookWriteModelRepository extends JpaRepository<BookWriteModel, String> {
}
