package primitives;

import org.junit.jupiter.api.Test;
import primitives.*;


import static java.lang.StrictMath.sqrt;
import static org.junit.jupiter.api.Assertions.*;


class VectorTest {

    @Test
    void length() {
        Vector v= new Vector(new Point3D(2.0,2.0,0.0));
        assertEquals(sqrt(8.0),v.length());
    }

    @org.junit.jupiter.api.Test
    void testNormalize() {
        Vector v = new Vector(new Point3D(3.5,-5,10));
        v.normalize();
        System.out.println(v.length());
        assertEquals( 1.0, v.length(),1e-10);

        v = new Vector();   //vector(0,0,0) cannot be normalized
        try {
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (ArithmeticException e) {
            System.out.println("throw divide by zero exception");
            assertTrue(true);
        }
    }

    @org.junit.jupiter.api.Test
    void toStringTest() {
    }
}