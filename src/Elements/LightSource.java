package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public interface LightSource{

    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point); // light to point vector

}

