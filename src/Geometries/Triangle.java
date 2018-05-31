package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Triangle extends Geometry implements FlatGeometry

{
    protected Point3D _x;
    protected Point3D _y;
    protected Point3D _z;

    //************Constructors************//
    public Triangle()
    {
        _x=new Point3D();
        _y=new Point3D();
        _z=new Point3D();
    }
    public Triangle(Point3D a,Point3D b, Point3D c)
    {
        super();
        _x=new Point3D(a);
        _y=new Point3D(b);
        _z=new Point3D(c);
    }
    public Triangle(Point3D a,Point3D b, Point3D c, Color emission, Material material )
    {
        super(emission, material);
        _x=new Point3D(a);
        _y=new Point3D(b);
        _z=new Point3D(c);
    }
    public Triangle(Point3D a,Point3D b, Point3D c, Color emission )
    {
        super(emission);
        _x=new Point3D(a);
        _y=new Point3D(b);
        _z=new Point3D(c);
    }

    public Triangle(Triangle t)// copy constructor
    {

        _x=new Point3D(t.get_x());
        _y=new Point3D(t.get_y());
        _z=new Point3D(t.get_z());
    }

    public Triangle(Map<String, String> attributes){

        String[] P0coordinates = attributes
                .get("P0" ).split("\\s+");

        _x = new Point3D(Double.valueOf(P0coordinates[0]),
                Double.valueOf(P0coordinates[1]),
                Double.valueOf(P0coordinates[2]));

        String[] P1coordinates = attributes
                .get("P1" ).split("\\s+");

        _y = new Point3D(Double.valueOf(P1coordinates[0]),
                Double.valueOf(P1coordinates[1]),
                Double.valueOf(P1coordinates[2]));

        String[] P2coordinates = attributes
                .get("P2" ).split("\\s+");

        _z = new Point3D(Double.valueOf(P2coordinates[0]),
                Double.valueOf(P2coordinates[1]),
                Double.valueOf(P2coordinates[2]));

    }



    //************Getters/Setters************//

    public Point3D get_x(){return new Point3D(_x);}
    public Point3D get_y(){return new Point3D(_y);}
    public Point3D get_z(){return new Point3D(_z);}

    //sets
    public void set_x(Point3D p){_x.setPoint3D(p);}
    public void set_y(Point3D p){_y.setPoint3D(p);}
    public void set_z(Point3D p){_z.setPoint3D(p);}


    //************Administration************//

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;
        if (_x == null) {
            if (other._x != null)
                return false;
        } else if (!_x.equals(other._x))
            return false;
        if (_y == null) {
            if (other._y != null)
                return false;
        } else if (!_y.equals(other._y))
            return false;
        if (_z == null) {
            if (other._z != null)
                return false;
        } else if (!_z.equals(other._z))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Triangle { _x: "+_x+", _y: "+_y+", _z: "+_z+"}"+ super.toString();
    }

    //************Functions************//


    public  Vector getNormal(Point3D p)
    {
        Vector v1= new Vector (_x,_y);
        Vector v2= new Vector (_x,_z);
        Vector v3= new Vector (v2.crossProduct(v1));

        v3.normalize();
        v3.scale(-1);

        return v3;
    }

    @Override

    public List<Point3D> findIntersections(Ray ray)
    {
        List<Point3D> list= new ArrayList<Point3D>();
        Point3D p0=ray.getPOO();
        Vector n =getNormal(null);// n is the direction to point p3
        Plane plane= new Plane(n, _z);
        ArrayList<Point3D> planeList= (ArrayList<Point3D>)plane.findIntersections(ray);

        if (planeList.isEmpty())//there are no intersection points
        {
            //	System.out.println("in triangle intersection if empty");


            return list;
        }
        //System.out.println("in triangle intersection if  ***NOT*** empty");
        //there is an intersection point. save it in point
        Point3D point= planeList.get(0);
        Vector pt= new Vector(p0, point);

        //checking first side
        Vector firstV1= new Vector(p0, _x);
        Vector firstV2= new Vector(p0, _y);
        Vector firstN= new Vector(firstV1.crossProduct(firstV2));
        firstN.normalize();
        double side1= (pt.dotProduct(firstN))+0.0;

        //checking second side
        Vector secondV1= new Vector(p0,_y);
        Vector secondV2= new Vector(p0,_z);
        Vector secondN= new Vector(secondV1.crossProduct(secondV2));
        secondN.normalize();
        double side2= (pt.dotProduct(secondN))+0.0;

        //checking third side

        Vector thirdV1= new Vector(p0,_z);
        Vector thirdV2= new Vector(p0,_x);
        Vector thirdN=  thirdV1.crossProduct(thirdV2);
        thirdN.normalize();
        double side3= (pt.dotProduct(thirdN))+0.0;

        if((side1>0 && side2>0 && side3>0)|| (side1<0 && side2<0 && side3<0))
            list.add(point);
        return list;

    }




}

