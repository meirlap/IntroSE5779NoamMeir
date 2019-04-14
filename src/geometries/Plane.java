package geometries;

import primitives.*;
import java.util.Objects;

public class Plane implements IGeometry{
    Point3D point3D;
    Vector normal;

    public Plane (Point3D a,Point3D b,Point3D c)  {

            Vector v1 = new Vector(a, b);
            Vector v2 = new Vector(a, c);
            Vector v = v2.crossProduct(v1);
            v.normalize();
            v.scale(-1);
        setNormal(v);
    }

    public Plane(Point3D point3D, Vector vector) {
        this.point3D =new Point3D( point3D);
        this.normal = new Vector(vector);
    }
    public Plane() {
        this.point3D =new Point3D();
        this.normal = new Vector();
    }
    public Plane(Plane plane) {
        this.point3D =new Point3D(plane.point3D);
        this.normal = new Vector(plane.normal);
    }
    public Point3D getPoint() {
        return new Point3D(point3D);
    }

    public void setPoint(Point3D point) {
        this.point3D = new Point3D(point);
    }

    public Vector getNormal() {
        return new Vector(normal);
    }

    public void setNormal(Vector vector) {
        this.normal = new Vector(vector);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(point3D, plane.point3D) &&
                Objects.equals(getNormal(), plane.getNormal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(point3D, getNormal());
    }

    @Override
    public String toString() {
        return "Plane{" +
                "point3D=" + point3D +
                ", vector=" + normal +
                '}';
    }

    public Vector getNormal(Point3D p) {
        return new Vector(normal);
    }
}
