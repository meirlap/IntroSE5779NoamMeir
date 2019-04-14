package primitives;

import java.util.Objects;

import static java.lang.StrictMath.*;

public class Vector {
    private Point3D head;

    /********** Constructors ***********/
    public Vector() {
        this.setHead(Point3D.POINT_ZERO);
    }

    public Vector(Point3D head) {
        if (head.equals(Point3D.POINT_ZERO)) {
            try {
                throw new Exception("Explicit Vector with zero not allowed");
            } catch (Exception e) {
                //TO DO
                e.printStackTrace();
            }
        }

        this.setHead(head);
    }

    public Vector(Vector vec) {
        this.head = new Point3D(vec.getHead());
    }

    public Vector(Point3D a, Point3D b) {
        setHead(new Point3D(
                b.get_x().subtract(a.get_x()),
                b.get_y().subtract(a.get_y()),
                b.get_z().subtract(a.get_z())));
    }

    /************** Getters/Setters *******/
    public Point3D getHead() {
        return new Point3D(head);
    }

    public void setHead(Point3D head) {
        this.head = new Point3D(head);
    }

    public void add(Vector vector) {
        this.head.set_x(this.head.get_x().add(vector.head.get_x()));
        this.head.set_y(this.head.get_y().add(vector.head.get_y()));
        this.head.set_z(this.head.get_z().add(vector.head.get_z()));
    }

    public void subtract(Vector vector) {
        this.head.set_x(this.head.get_x().subtract(vector.head.get_x()));
        this.head.set_y(this.head.get_y().subtract(vector.head.get_y()));
        this.head.set_z(this.head.get_z().subtract(vector.head.get_z()));
    }

    public double length() {
        return sqrt(
                Util.uadd(
                        Util.uscale(this.head.get_x().get(), this.head.get_x().get())
                        , Util.uscale(this.head.get_y().get(), this.head.get_y().get())));
    }

    public void normalize() {
        double length = this.length();
        if (Util.isZero(length)) {
            throw new ArithmeticException();
        }

        this.head.set_x(new Coordinate(this.head.get_x().get() / length));
        this.head.set_y(new Coordinate(this.head.get_y().get() / length));
        this.head.set_z(new Coordinate(this.head.get_z().get() / length));

    }

    /************** Administration *******/
    public void scale(double scalingFactor) {

        this.head.set_x(new Coordinate(
                head.get_x().scale(scalingFactor)));

        this.head.set_y(new Coordinate(
                head.get_y().scale(scalingFactor)));

        this.head.set_z(new Coordinate(
                head.get_z().scale(scalingFactor)));
    }

    public Vector crossProduct(Vector vector) {

        double x1 = this.getHead().get_x().get();
        double y1 = this.getHead().get_y().get();
        double z1 = this.getHead().get_z().get();

        double x2 = vector.getHead().get_x().get();
        double y2 = vector.getHead().get_y().get();
        double z2 = vector.getHead().get_z().get();

        return new Vector(new Point3D(
                new Coordinate(Util.usubtract(Util.uscale(y1, z2), Util.uscale(z1, y2))),
                new Coordinate(Util.usubtract(Util.uscale(z1, x2), Util.uscale(x1, z2))),
                new Coordinate(Util.usubtract(Util.uscale(x1, y2), Util.uscale(y1, x2)))));
    }

    public double dotProduct(Vector vector) {
        return ((this.head.get_x().get() * vector.head.get_x().get() +
                this.head.get_y().get() * vector.head.get_y().get() +
                this.head.get_z().get() * (vector.head.get_z().get())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return getHead().equals(vector.getHead());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }

    @Override
    public String toString() {
        return "Vector{" +
                "head=" + head +
                '}';
    }
}