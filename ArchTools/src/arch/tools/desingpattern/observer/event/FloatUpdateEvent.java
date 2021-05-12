package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class FloatUpdateEvent extends UpdateEvent {

    private final float before;
    private final float now;

    public FloatUpdateEvent(Object source, float before, float now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final float getBefore() {
        return before;
    }

    public final float getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FloatUpdateEvent that = (FloatUpdateEvent) o;
        return Float.compare(that.before, before) == 0 && Float.compare(that.now, now) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }
}
