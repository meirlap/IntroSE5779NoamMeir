package geometries;

import primitives.*;

import java.util.Objects;

public class Tube extends RadialGeometry{
   protected Vector vector;

    public Tube(Double _radius,Vector vector) {
        super(_radius);
       setVector(vector);
    }

    public Tube() {
        super(0.0);
        setVector(new Vector());
    }

    public Tube(Tube tube) {
        super(tube.get_radius());
        setVector(new Vector(tube.getVector()));

    }
    public Vector getVector() {
        return new Vector(vector);
    }

    public void setVector(Vector vector) {
        this.vector = new Vector(vector);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tube)) return false;
        Tube tube = (Tube) o;
        return Objects.equals(getVector(), tube.getVector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVector());
    }

    @Override
    public String toString() {
        return "Tube{" +
                "vector=" + vector +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
