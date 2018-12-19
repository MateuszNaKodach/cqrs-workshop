package io.github.nowakprojects.cqrsworkshop.cqrs.read;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookReadModelRepository extends MongoRepository<BookReadModel,String> {
}
