package elements;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CameraTest {
    @Test
    public void testConstructRay1() {
        //System.out.println("Test Ray Through Pixel");

        Vector vup = new Vector(0, 1, 0);
        Vector vto = new Vector(0, 0, -1);

        Camera c = new Camera(vup, vto);

        Ray ray = c.constructRayThroughPixel(3, 3,
                3 , 3,
                100,
                150, 150);
        Point3D centerPoint = new Point3D(100,-100,-100);
        Vector direction = new Vector(0.5773502691896257, -0.5773502691896257, -0.5773502691896257);

        Ray answer = new Ray(centerPoint, direction);
        assertEquals(answer, ray);
    }

}