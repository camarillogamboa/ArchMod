package arch.math.point;

import java.util.Objects;

public class IntPoint3D extends IntPoint2D {

    private int z;

    public IntPoint3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public IntPoint3D() {
        this(0, 0, 0);
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public IntPoint3D cloneThis() {
        return new IntPoint3D(getX(), getY(), z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var that = (IntPoint3D) o;
        return z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
}
