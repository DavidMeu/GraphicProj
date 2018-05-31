package Geometries;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;

public abstract class Geometry
{
    private Color _emission; //Color that the element puts out.
    private Material _material;

    // ***************** Constructors ********************** //
    public Geometry()
    {
        _emission= new Color(0,0,0);
        _material= new Material();
    }

    public Geometry(Color emission, Material material)
    {
        _emission=emission; // new Color(emission.getRed(),emission.getGreen(),emission.getBlue());
        _material= new Material(material);
    }

    public Geometry(Color emission)
    {
        _emission= emission; //new Color(emission.getRed(),emission.getGreen(),emission.getBlue());
        _material= new Material();
    }
    public Geometry(Geometry geometry)
    {
        _emission= new Color(geometry.getEmission().getRed(),geometry.getEmission().getGreen(),geometry.getEmission().getBlue());
        _material= new Material(geometry.getKD(),geometry.getKS(),geometry.getKR(),geometry.getKT(),geometry.getNshininess());
    }

    // ***************** Constructors ********************** //

    // ***************** Getters/Setters ********************** //
    public Color getEmission(){return _emission;}
    public void setEmission(Color c){_emission=c;}//new Color(c.getRed(),c.getGreen(),c.getBlue());}
    //public Color getEmission(){return _emission;}
    //public void setEmission(Color c){_emission=c;}
    public Material getMaterial(){return _material;}
    public void setMaterial(Material material){_material= material;}

    public double getKD(){return _material.getKD();}
    public double getKS(){return _material.getKS();}
    public double getKR(){return _material.getKR();}
    public double getKT(){return _material.getKT();}


    public void setKD(double kd){_material.setKD(kd);}
    public void setKS(double ks){_material.setKS(ks);}
    public void setKR(double kr){_material.setKR(kr);}
    public void setKT(double kt){_material.setKT(kt);}


    public int getNshininess(){return this._material.getNshininess();}
    public void setNshininess(int nShininess){this._material.setNshininess(nShininess);}

    // ***************** Getters/Setters ********************** //

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object obj)
    {
        if (this== obj)
            return true;
        if (obj==null)
            return false;
        if(!(obj instanceof Geometry))
            return false;
        Geometry other= (Geometry) obj;
        if(_emission== null)
        {
            if(other._emission != null)
                return false;
        }
        else if (!_emission.equals(other._emission))
            return false;

        if(_material== null)
        {
            if(other._material != null)
                return false;
        }
        else if (!_material.equals(other._material))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Geometry { _emission: "+_emission+", _material: "+_material+"}";
    }

    // ***************** Operations ******************** //
    public abstract Vector getNormal(Point3D p);
    public abstract List<Point3D> findIntersections(Ray r);

}
