package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class LongUpdateEvent extends UpdateEvent {

    private final long before;
    private final long now;

    public LongUpdateEvent(Object source, long before, long now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final long getBefore() {
        return before;
    }

    public final long getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LongUpdateEvent that = (LongUpdateEvent) o;
        return before == that.before && now == that.now;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }

}
