package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class DoubleUpdateEvent extends UpdateEvent {

    private final double before;
    private final double now;

    public DoubleUpdateEvent(Object source, double before, double now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final double getBefore() {
        return before;
    }

    public final double getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoubleUpdateEvent that = (DoubleUpdateEvent) o;
        return Double.compare(that.before, before) == 0 && Double.compare(that.now, now) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }
}
