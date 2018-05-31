package Primitives;

import Primitives.Coordinate;

public class Point2D  implements Comparable<Point2D> {

    protected Coordinate _x;
    protected Coordinate _y;

    // ***************** Constructors ********************** //

    public Point2D(){
        _x = new Coordinate();
        _y = new Coordinate();
    }

    public Point2D(Coordinate x, Coordinate y){
        _x = new Coordinate(x);
        _y = new Coordinate(y);
    }

    public Point2D(Point2D point2D){
        _x = point2D.getX();
        _y = point2D.getY();
    }

    // ***************** Getters/Setters ********************** //

    public Coordinate getX() { return new Coordinate(_x); }
    public Coordinate getY() { return new Coordinate(_y); }

    public void setX(Coordinate _x) { this._x = new Coordinate(_x);	}
    public void setY(Coordinate _y) { this._y = new Coordinate(_y);	}

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object obj)
    {
        if (this== obj)
            return true;
        if (obj==null)
            return false;
        if (!(obj instanceof Point2D)) return false;
        Point2D n = (Point2D)obj;
        return (_x.equals(n._x)&&_y.equals(n._y));
    }

    @Override
    public int compareTo(Point2D point2D) {
        if (this._x.compareTo(point2D._x) == 0 &&
                this._y.compareTo(point2D._y) == 0)
            return 0;
        return 1;
    }
    // ***************** Operations ******************** //


    @Override
    public String toString() {
        return "(" + _x.getCoordinate() + ", " +
                _y.getCoordinate() + ")" ;
    }
}
