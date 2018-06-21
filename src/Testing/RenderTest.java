package Testing;

import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Renderer.ImageWriter;
import Renderer.Render;
import Scenes.Scene;
import org.junit.Test;

import java.awt.*;


public class RenderTest {

    final String IMAGES_TEST_DIR = "/src/testing/images/";

    @Test
    public void basicRendering(){

        Scene scene = new Scene();
scene.setScreenDistance(150);
        Sphere s=new Sphere(100, new Point3D(0.0, 0.0, -600));
s.setEmission(new Color(0,0,225));
        Triangle triangle = new Triangle(new Point3D( 100, 0, -150),
                new Point3D(  0, 100, -150),
                new Point3D( 100, 100, -150));
triangle.setEmission(new Color(0,200,0));
        Triangle triangle2 = new Triangle(new Point3D( 100, 0, -150),
                new Point3D(  0, -100, -150),
                new Point3D( 100,-100, -150));
triangle2.setEmission(new Color(200,0,0));
        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -150),
                new Point3D(  0, 100, -150),
                new Point3D(-100, 100, -150));
triangle3.setEmission(new Color(193,197,17));
        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -150),
                new Point3D(  0,  -100, -150),
                new Point3D(-100, -100, -150));
triangle4.setEmission(new Color(0,230,2));
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
scene.addGeometry(s);
        ImageWriter imageWriter = new ImageWriter( "Render test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();

    }

}
