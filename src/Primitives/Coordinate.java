package Primitives;

public class Coordinate  implements Comparable<Coordinate> {

    private double _coordinate;

    // ***************** Constructors ********************** //

    public Coordinate()                      { this._coordinate = 0.0;                    }
    public Coordinate(double coordinate)     { this._coordinate = coordinate;             }
    public Coordinate(Coordinate coordinate) { this._coordinate = coordinate._coordinate; }

    // ***************** Getters/Setters ********************** //

    public double getCoordinate()                {	return _coordinate;	          }
    public void setCoordinate(double coordinate) { this._coordinate = coordinate; }

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Coordinate)) return false;
        Coordinate n = (Coordinate)o;
        return (_coordinate == n._coordinate);
    }

    @Override
    public int compareTo(Coordinate coordinate) {
        return Double.compare(this._coordinate, coordinate._coordinate);
    }

    // ***************** Operations ******************** //

    public void add (Coordinate coordinate ){
        this._coordinate += coordinate._coordinate;
    }

    public void subtract(Coordinate coordinate) {
        this._coordinate -= coordinate._coordinate;
    }

}
