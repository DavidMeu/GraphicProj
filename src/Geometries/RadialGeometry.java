package Geometries;

import java.awt.Color;

import Primitives.Material;

public abstract class RadialGeometry extends Geometry
{
    protected double _radius;

    // ***************** Constructors ********************** //
    public RadialGeometry()
    {
        super();
        _radius=0.0;
    }
    public RadialGeometry(double r)
    {
        super();
        _radius=r;

    }
    public RadialGeometry(double r, Color emission, Material material)
    {
        super(emission,material);
        _radius=r;

    }

    // ***************** Constructors ********************** //

    // ***************** Getters/Setters ********************** //

    public double getRadius(){return _radius;}
    public void setRadius(double radius){_radius= radius;}

    // ***************** administration ********************** //

    @Override
    public boolean equals(Object obj)
    {
        if (this== obj)
            return true;
        if (obj==null)
            return false;
        if(!(obj instanceof RadialGeometry))
            return false;
        RadialGeometry other= (RadialGeometry) obj;

        if(!super.equals(obj))
            return false;
        if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "RadialGeometry { _radius: "+_radius+"}"+super.toString();
    }
}
