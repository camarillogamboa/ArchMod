package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class IntUpdateEvent extends UpdateEvent {

    private final int before;
    private final int now;

    public IntUpdateEvent(Object source, int before, int now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final int getBefore() {
        return before;
    }

    public final int getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IntUpdateEvent that = (IntUpdateEvent) o;
        return before == that.before && now == that.now;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }
}
