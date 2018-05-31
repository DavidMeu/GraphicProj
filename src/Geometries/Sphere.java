package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Sphere extends RadialGeometry
{
    private Point3D _center;

    // ***************** Constructors ********************** //
    public Sphere()
    {
        super();
        _center=new Point3D();
    }
    public Sphere(double r,Point3D p)
    {
        super(r);
        _center=new Point3D(p);
        //point.distance(p);
    }

    public Sphere(Point3D p, double r, Color emission, Material material)
    {
        super(r,emission,material);
        _center=new Point3D(p);
        //point.distance(p);
    }

    public Sphere(Sphere sphere)
    {
        super(sphere.getRadius(),sphere.getEmission(),sphere.getMaterial());
        _center=new Point3D(sphere.get_point());

        //point.distance(p);
    }
    public Sphere(Map<String, String> attributes){

        String[] centerPoints = attributes
                .get("center" ).split("\\s+");

        _center = new Point3D(Double.valueOf(centerPoints[0]),
                Double.valueOf(centerPoints[1]),
                Double.valueOf(centerPoints[2]));

        _radius = Double.valueOf(attributes.get("radius"));
    }


    // ***************** Getters/Setters ********************** //

    public Point3D get_point(){return new Point3D(_center);}
    public void set_point(Point3D p){_center.setPoint3D(p);}

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object obj)
    {
        if (this== obj)
            return true;
        if (obj==null)
            return false;
        if(!(obj instanceof Sphere))
            return false;
        Sphere other= (Sphere) obj;
        if(_center== null)
        {
            if(other._center != null)
                return false;
        }
        else if (!_center.equals(other._center))
            return false;
        if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Sphere { _point: "+_center+"}"+super.toString();
    }

    // ***************** Operations ******************** //

    @Override
    public List<Point3D> findIntersections(Ray ray)
    {
        //System.out.println("ray is " + ray);
        List<Point3D> intersections= new ArrayList<Point3D>();
        Point3D p0= new Point3D(ray.getPOO());
        Vector v= new Vector(ray.getDirection());
        Point3D p1= new Point3D(ray.getPOO());
        Point3D p2= new Point3D(ray.getPOO());
        Vector L= new Vector(p0,_center);

        double tm= L.dotProduct(v);
        double d= Math.sqrt((Math.pow(L.length(),2.0))-Math.pow(tm, 2));
        //	System.out.println("d is " + d + " radius is " + this._radius);
        if(d>this._radius)
            return intersections;
        //System.out.println("after first return");
        double th= Math.sqrt(Math.pow(_radius, 2)-Math.pow(d, 2));
        double t1= tm-th;
        if (t1>0)
        {
            Vector vector = ray.getDirection();
            vector.scale(t1);
            p1.add(vector);
            intersections.add(p1);
        }
        double t2= tm+th;
        if(t2>0)
        {
            Vector vector= ray.getDirection();
            vector.scale(t2);
            p2.add(vector);
            intersections.add(p2);
        }
        return intersections;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        Vector N= new Vector(_center,p);
        N.normalize();
        return N;
    }
}


























