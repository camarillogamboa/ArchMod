package arch.math.point;

import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;

public class LongPoint2D implements Prototype<LongPoint2D> {

    private long x;
    private long y;

    public LongPoint2D(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public LongPoint2D() {
        this(0, 0);
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(long y) {
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public LongPoint2D cloneThis() {
        return new LongPoint2D(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (LongPoint2D) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static double distance(LongPoint2D p, LongPoint2D q) {
        return Math.sqrt(Math.pow(q.x - p.x, 2) + Math.pow(q.y - p.y, 2));
    }

}
