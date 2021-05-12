package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class ShortUpdateEvent extends UpdateEvent {

    private final short before;
    private final short now;

    public ShortUpdateEvent(Object source, short before, short now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final short getBefore() {
        return before;
    }

    public final short getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShortUpdateEvent that = (ShortUpdateEvent) o;
        return before == that.before && now == that.now;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }

}
