package arch.math.point;

import java.util.Objects;

public class LongPoint3D extends LongPoint2D {

    private long z;

    public LongPoint3D(long x, long y, long z) {
        super(x, y);
        this.z = z;
    }

    public LongPoint3D() {
        this(0, 0, 0);
    }

    public void setZ(long z) {
        this.z = z;
    }

    public long getZ() {
        return z;
    }

    @Override
    public LongPoint3D cloneThis() {
        return new LongPoint3D(getX(), getY(), z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var that = (LongPoint3D) o;
        return z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
}
