package geometries;

import primitives.*;

import java.util.Objects;

public class Sphere extends RadialGeometry {
    Point3D center;

    public Sphere(double _radius, Point3D center) {
        super(_radius);
        this.center = center;
    }

    public Sphere(RadialGeometry shape, Point3D center) {
        super(shape);
        this.center = center;
    }
    public Sphere(Sphere sphere) {
        super(sphere._radius);
        this.center =new Point3D(center);
    }
    public Point3D getCenter() {
        return new Point3D(center);
    }

    public void setCenter(Point3D center) {
        this.center = new Point3D(center);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sphere)) return false;
        Sphere sphere = (Sphere) o;
        return Objects.equals(getCenter(), sphere.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCenter());
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
