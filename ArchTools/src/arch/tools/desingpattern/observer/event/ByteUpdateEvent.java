package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class ByteUpdateEvent extends UpdateEvent {

    private final byte before;
    private final byte now;

    public ByteUpdateEvent(Object source, byte before, byte now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final byte getBefore() {
        return before;
    }

    public final byte getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ByteUpdateEvent that = (ByteUpdateEvent) o;
        return before == that.before && now == that.now;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }

}
