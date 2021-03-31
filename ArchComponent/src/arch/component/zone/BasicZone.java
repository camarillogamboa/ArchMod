package arch.component.zone;

import arch.math.point.IntPoint2D;

public interface BasicZone {

    void setX(int x);

    void setY(int y);

    void setWidth(int width);

    void setHeight(int height);

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    default int[] getCoord(){
        return new int[]{getX(),getY()};
    }

    default IntPoint2D getOrigin(){
        return new IntPoint2D(getX(),getY());
    }

}
