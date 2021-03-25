package arch.math.point;

import java.util.Objects;

public class FloatPoint3D extends FloatPoint2D {

    private float z;

    public FloatPoint3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public FloatPoint3D() {
        this(0, 0, 0);
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    @Override
    public FloatPoint3D cloneThis() {
        return new FloatPoint3D(getX(), getY(), z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var that = (FloatPoint3D) o;
        return Float.compare(that.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
}
