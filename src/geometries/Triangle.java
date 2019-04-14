package geometries;

import primitives.*;

import java.util.Objects;

public class Triangle extends Plane {
    Point3D a;
    Point3D b;
    Point3D c;

    public Triangle(Point3D a, Point3D b, Point3D c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {
        this.a = new Point3D();
        this.b = new Point3D();
        this.c = new Point3D();
    }

    public Triangle(Triangle triangle) {
        this.a = new Point3D(triangle.a);
        this.b = new Point3D(triangle.b);
        this.c = new Point3D(triangle.c);

    }

    public Point3D getA() {
        return new Point3D(a);
    }

    public void setA(Point3D a) {
        this.a = new Point3D(a);
    }

    public Point3D getB() {
        return new Point3D(b);
    }

    public void setB(Point3D b) {
        this.b = new Point3D(b);
    }

    public Point3D getC() {
        return new Point3D(c);
    }

    public void setC(Point3D c) {
        this.c = new Point3D(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(getA(), triangle.getA()) &&
                Objects.equals(getB(), triangle.getB()) &&
                Objects.equals(getC(), triangle.getC());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), getC());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }


    public Vector getNormal(Point3D p) {
        Vector v1 = new Vector(a, b);
        Vector v2 = new Vector(c, b);
        Vector v = v2.crossProduct(v1);
        v.normalize();
        v.scale(-1);
        return v;

    }
}
