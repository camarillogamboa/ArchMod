package arch.math.point;

import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;

public class FloatPoint2D implements Prototype<FloatPoint2D> {

    private float x;
    private float y;

    public FloatPoint2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public FloatPoint2D() {
        this(0, 0);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public FloatPoint2D cloneThis() {
        return new FloatPoint2D(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (FloatPoint2D) o;
        return Float.compare(that.x, x) == 0 && Float.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static double distance(FloatPoint2D p, FloatPoint2D q) {
        return Math.sqrt(Math.pow(q.x - p.x, 2) + Math.pow(q.y - p.y, 2));
    }

}
