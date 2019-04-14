package geometries;

import primitives.*;

public class Cylinder extends  Tube{
    Point3D point;

    public Cylinder(Double _radius, Vector vector, Point3D point) {
        super(_radius, vector);
        setPoint(point);
    }

    public Point3D getPoint() {
        return new Point3D(point);
    }

    public void setPoint(Point3D point) {
        this.point = new Point3D(point);
    }
}
