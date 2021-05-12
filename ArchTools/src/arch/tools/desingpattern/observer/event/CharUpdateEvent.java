package arch.tools.desingpattern.observer.event;

import java.util.Objects;

public class CharUpdateEvent extends UpdateEvent {

    private final char before;
    private final char now;

    public CharUpdateEvent(Object source, char before, char now) {
        super(source);
        this.before = before;
        this.now = now;
    }

    public final char getBefore() {
        return before;
    }

    public final char getNow() {
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CharUpdateEvent that = (CharUpdateEvent) o;
        return before == that.before && now == that.now;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), before, now);
    }
}
