package arch.math.point;

import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;

public class IntPoint2D implements Prototype<IntPoint2D> {

    private int x;
    private int y;

    public IntPoint2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IntPoint2D() {
        this(0, 0);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public IntPoint2D cloneThis() {
        return new IntPoint2D(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (IntPoint2D) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static double distance(IntPoint2D p, IntPoint2D q) {
        return Math.sqrt(Math.pow(q.x - p.x, 2) + Math.pow(q.y - p.y, 2));
    }

}
