package io.github.nowakprojects.cqrsworkshop.cqrs.event;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {

    private final String id;
    private final Instant occurredDate;

    public DomainEvent() {
        this.id = UUID.randomUUID().toString();
        this.occurredDate = Instant.now();
    }

    public String getId() {
        return id;
    }

    public Instant getOccurredDate() {
        return occurredDate;
    }
}
