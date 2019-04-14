package primitives;
import java.util.Objects;
import static java.lang.StrictMath.*;

public class Point3D extends Point2D {
    public static final Point3D POINT_ZERO =  new Point3D();

    private Coordinate _z;

    /********** Constructors ***********/
    public Point3D() {
        this.set_z(Coordinate.ZERO);
    }
    public Point3D(Point3D other) {
        this.set_x(other.get_x());
        this.set_y(other.get_y());
        this.set_z(other.get_z());
    }
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.set_z(z);
    }

    public Point3D(double x, double y, double z) {
        super(x,y);
        set_z(new Coordinate(z));
    }

    /************** Getters/Setters *******/
    public Coordinate get_z() {
        return  new Coordinate(_z);
    }

    public void set_z(Coordinate z) {
        this._z =  new Coordinate(z);
    }

    /************** Administration *******/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Point3D)) return false;
        if (!super.equals(obj)) return false;
        Point3D point3D = (Point3D) obj;
        return get_z().equals(point3D.get_z());
    }
    public double length(Point3D p){
        return sqrt( pow(this.get_x().get() - p.get_x().get(),2) +
                pow(this.get_y().get() - p.get_y().get(),2)+
                pow(this.get_z().get() - p.get_z().get(),2));
    }
    public void addVector(Vector v)
    {
        Point3D result = new Point3D(
                this.get_x().add(v.getHead().get_x()),
                this.get_y().add(v.getHead().get_y()),
                this.get_z().add(v.getHead().get_z()));
        this.set_x(result.get_x());
        this.set_y(result.get_y());
        this.set_z(result.get_z());
    }
    public void subVector(Vector v)
    {
        Point3D result = new Point3D(
                this.get_x().subtract(v.getHead().get_x()),
                this.get_y().subtract(v.getHead().get_y()),
                this.get_z().subtract(v.getHead().get_z()));
        this.set_x(result.get_x());
        this.set_y(result.get_y());
        this.set_z(result.get_z());
    }
    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.get_x() +
                ", y=" + super.get_y() +
                ", z=" + get_z() +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), get_z());
    }



}