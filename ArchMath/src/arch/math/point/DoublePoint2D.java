package arch.math.point;

import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;

public class DoublePoint2D implements Prototype<DoublePoint2D> {

    private double x;
    private double y;

    public DoublePoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public DoublePoint2D() {
        this(0, 0);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public DoublePoint2D cloneThis() {
        return new DoublePoint2D(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (DoublePoint2D) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static double distance(DoublePoint2D p, DoublePoint2D q) {
        return Math.sqrt(Math.pow(q.x - p.x, 2) + Math.pow(q.y - p.y, 2));
    }
}
