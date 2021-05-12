package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class ReferenceUpdateEvent<T> extends UpdateEvent {

    private final T before;
    private final T now;

    public ReferenceUpdateEvent(Object source, T before, T now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final T getBefore() {
        return before;
    }

    public final T getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReferenceUpdateEvent<?> that = (ReferenceUpdateEvent<?>) o;
        return Objects.equals(before, that.before) && Objects.equals(now, that.now);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }
}
