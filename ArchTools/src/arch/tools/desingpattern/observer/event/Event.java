package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class Event {

    private final Object source;

    public Event(Object source) {
        this.source = Objects.requireNonNull(source);
    }

    public final Object getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(source, event.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source);
    }

}
