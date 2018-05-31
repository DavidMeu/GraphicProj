package Primitives;

public class Material
{
    double _kd;//מספרים ממשיים המייצגים את גורמי הרחקה.
    double _ks;

    double _kr;// kr=1 האובייקט מראה כאשר ,kr=0- האובייקט הוא מט כאשר
    double _kt;	//KT = 1 כאשר האובייקט הוא שקוף, KT = 0	כאשר האובייקט הוא אטום


    int _nShininess;//מספר שלם המייצג מידת מבהיקות של החומר

    public Material()
    {
        _kd=1.0;
        _ks=1.0;
        _kr=0.0;
        _kt=0.0;
        _nShininess=1;

    }
    public Material(double kd, double ks,double kr, double kt, int nShininess)
    {
        _kd=kd;
        _ks=ks;
        _kr=kr;
        _kt=kt;
        _nShininess=nShininess;
    }
    public Material(Material material)
    {
        _kd=material._kd;
        _ks=material._ks;
        _kr=material._kr;
        _kt=material._kt;
        _nShininess=material._nShininess;
    }

    // get & set
    public double getKD(){return _kd;}
    public double getKS(){return _ks;}
    public double getKR(){return _kr;}
    public double getKT(){return _kt;}
    public int getNshininess(){return _nShininess;}

    public void setKD(double kd){_kd=kd;}
    public void setKS(double ks){_ks=ks;}
    public void setKR(double kr){_kr=kr;}
    public void setKT(double kt){_kt=kt;}

    public void setNshininess(int nShininess){_nShininess=nShininess;}
//	System.out.println("setNshininess= " +_nShininess);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Material other = (Material) obj;
        if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
            return false;
        if (Double.doubleToLongBits(_kr) != Double.doubleToLongBits(other._kr))
            return false;
        if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
            return false;
        if (Double.doubleToLongBits(_kt) != Double.doubleToLongBits(other._kt))
            return false;
        if (_nShininess != other._nShininess)
            return false;
        return true;
    }

    public String toString()
    {
        return "Material { _kd: "+_kd+", _ks: "+_ks+", _kr: "+_kr+", _kt: "+_kt+", _nShininess: "+_nShininess+"}";
    }



}
