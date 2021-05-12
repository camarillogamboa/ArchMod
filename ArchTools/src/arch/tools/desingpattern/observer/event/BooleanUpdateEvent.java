package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class BooleanUpdateEvent extends UpdateEvent {

    private final boolean before;
    private final boolean now;

    public BooleanUpdateEvent(Object source, boolean before, boolean now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final boolean getBefore() {
        return before;
    }

    public final boolean getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BooleanUpdateEvent that = (BooleanUpdateEvent) o;
        return before == that.before && now == that.now;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }
}
