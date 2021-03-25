package arch.math.point;

import java.util.Objects;

public class DoublePoint3D extends DoublePoint2D {

    private double z;

    public DoublePoint3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public DoublePoint3D() {
        this(0, 0, 0);
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public DoublePoint3D cloneThis() {
        return new DoublePoint3D(getX(), getY(), z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var that = (DoublePoint3D) o;
        return Double.compare(that.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

}
