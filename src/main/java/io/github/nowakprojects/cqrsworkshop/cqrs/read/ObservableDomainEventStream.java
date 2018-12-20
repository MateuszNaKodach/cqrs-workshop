package io.github.nowakprojects.cqrsworkshop.cqrs.read;

import io.github.nowakprojects.cqrsworkshop.cqrs.event.DomainEvent;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.springframework.stereotype.Component;

@Component
public class ObservableDomainEventStream {

    private Subject<DomainEvent> subject = PublishSubject.<DomainEvent>create().toSerialized();

    public Flowable<DomainEvent> eventStream() {
        return subject.toFlowable(BackpressureStrategy.LATEST);
    }

    void pushEvent(DomainEvent event) {
        subject.onNext(event);
    }

}
