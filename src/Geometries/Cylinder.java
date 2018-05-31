package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Cylinder extends RadialGeometry
{
    Point3D _point;
    Vector _direction;




    // ***************** Constructors ********************** //
    public Cylinder()
    {
        super();
        _point=new Point3D();
        _direction= new Vector();

    }
    public Cylinder(Point3D p, Vector v, double r)
    {
        super(r);
        _point=new Point3D(p);
        _direction= new Vector(v);
    }
    // ***************** Constructors ********************** //

    // ***************** Getters/Setters ********************** //
    public Point3D get_point(){return new Point3D(_point);}
    public Vector getDirection(){return new Vector(_direction);}

    public void set_point(Point3D p){_point= new Point3D(p);}
    public void setDirection(Vector d){_direction= new Vector(d);}

    // ***************** Getters/Setters ********************** //

    // ***************** Operations ******************** //

    public Vector getNormal(Point3D p){return new Vector();}

    public List<Point3D> findIntersections(Ray r)
    {
        List<Point3D> intersections= new ArrayList<Point3D>();
        return intersections;
    }
}




