package primitives;

import java.util.Objects;

import static java.lang.StrictMath.sqrt;

public class Point2D {
    protected Coordinate _x;
    protected Coordinate _y;

    /********** Constructors ***********/
    public Point2D() {
        set_x(Coordinate.ZERO);
        set_y(Coordinate.ZERO);
    }

    public Point2D(Coordinate x, Coordinate y) {
        set_x(x);
        set_y(y);
    }

    public Point2D(Point2D p) {
        set_x(p.get_x());
        set_y(p.get_y());
    }

    public Point2D(double x, double y) {
        set_x(new Coordinate(x));
        set_y(new Coordinate(y));
    }


    /************** Getters/Setters *******/
    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    public void set_x(Coordinate _x) {
        this._x = new Coordinate(_x);
    }

    public void set_y(Coordinate _y) {
        this._y = new Coordinate(_y);
    }

    public Coordinate get_y() {
        return new Coordinate(_y);
    }

    /************** Administration *******/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Point2D)) return false;
        Point2D other = (Point2D) obj;
        return get_x().equals(other.get_x()) && get_y().equals(other.get_y());
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + get_x() +
                ", y=" + get_y() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_x(), get_y());
    }

    public double distance(Point2D other) {
        double xx = Util.uscale((other.get_x().get() - get_x().get()), (other.get_x().get() - get_x().get()));
        double yy = Util.uscale((other.get_y().get() - get_y().get()), (other.get_y().get() - get_y().get()));

        return sqrt(xx + yy);
    }


}
