package arch.math.vector;

import arch.math.point.IntPoint2D;
import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;

public class IntVector2D implements Prototype<IntVector2D> {

    private final IntPoint2D p;
    private final IntPoint2D q;

    public IntVector2D(IntPoint2D p, IntPoint2D q) {
        this.p = Objects.requireNonNull(p);
        this.q = Objects.requireNonNull(q);
    }

    public IntVector2D(IntPoint2D q) {
        this(new IntPoint2D(), q);
    }

    public IntPoint2D getP() {
        return p;
    }

    public IntPoint2D getQ() {
        return q;
    }

    public double magnitude() {
        return IntPoint2D.distance(p, q);
    }

    @Override
    public IntVector2D cloneThis() {
        return new IntVector2D(p.cloneThis(), q.cloneThis());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (IntVector2D) o;
        return Objects.equals(p, that.p) && Objects.equals(q, that.q);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, q);
    }

}
