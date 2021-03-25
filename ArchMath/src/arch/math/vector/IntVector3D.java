package arch.math.vector;

import arch.math.point.IntPoint3D;
import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;

public class IntVector3D implements Prototype<IntVector3D> {

    private final IntPoint3D p;
    private final IntPoint3D q;

    public IntVector3D(IntPoint3D p, IntPoint3D q) {
        this.p = Objects.requireNonNull(p);
        this.q = Objects.requireNonNull(q);
    }

    public IntPoint3D getP() {
        return p;
    }

    public IntPoint3D getQ() {
        return q;
    }

    public double magnitude() {
        return 0;
    }

    @Override
    public IntVector3D cloneThis() {
        return new IntVector3D(p, q);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (IntVector3D) o;
        return Objects.equals(p, that.p) && Objects.equals(q, that.q);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, q);
    }
}
