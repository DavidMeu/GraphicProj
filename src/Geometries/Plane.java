package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plane extends Geometry implements FlatGeometry

{
    protected Point3D _q;
    protected Vector _normal;

    // ***************** Constructors ********************** //
    public Plane(Vector v,Point3D p) {
        super();
        _q = new Point3D(p);
        _normal = new Vector(v);

        try {
            this._normal.normalize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // ***************** Constructors ********************** //


    // ***************** Getters/Setters ********************** //

    public Point3D getQ() {
        return new Point3D(_q);
    }

    public Vector getNormal(Point3D p) {
        return new Vector(_normal);
    }

    public void setQ(Point3D p) {
        _q.setPoint3D(p);
    }

    public void setNormal(Vector v) {
        _normal.setVector(v);
    }

    // ***************** Getters/Setters ********************** //

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plane other = (Plane) obj;
        if (!Objects.equals(this._q, other._q)) {
            return false;
        }
        if (!Objects.equals(this._normal, other._normal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plane { _q: " + _q + ", _normal: " + _normal + "}" + super.toString();
    }

    // ***************** Operations ******************** //

    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> list = new ArrayList<Point3D>();
        //p0-Q0:
        Vector ray_direc = new Vector(ray.getDirection());//ray direc
        Point3D ray_P0 = new Point3D(ray.getPOO());//ray's point
        Vector plain_N = new Vector(this.getNormal(null));//plain normal
        Point3D plain_p1 = new Point3D(this.getQ());//plain p
        Vector tempVector = new Vector(plain_p1, ray_P0);
        double t = (plain_N.dotProduct(tempVector) * -1) / plain_N.dotProduct(ray_direc);
        if (t >= 0) {
            ray_direc.scale(t);//
            Vector v1 = new Vector(ray_direc);
            ray_P0.add(v1);
            Point3D p1 = new Point3D(ray_P0);
            list.add(p1);
        }
        return list;
    }
}

/*
-	מימוש לפונקציה האבסטרקטית getNormal.
*/



