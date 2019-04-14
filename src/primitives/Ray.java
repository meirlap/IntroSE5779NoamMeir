package primitives;

import java.util.Objects;

public class Ray {
    private Point3D head;
    private Vector direction;

    public Ray() {
    }

    public Ray(Point3D head, Vector direction) {
        this.setHead(head);
        this.setDirection(direction);
    }

    public Ray(Ray other) {
        setHead(other.head);
        setDirection(other.direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return getHead().equals(ray.getHead()) &&
                getDirection().equals(ray.getDirection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead(), getDirection());
    }

    @Override
    public String toString() {
        return "Ray{" +
                "head=" + getHead() +
                ", direction=" + getDirection() +
                '}';
    }


    public Point3D getHead() {
        return new Point3D(head);
    }

    public void setHead(Point3D head) {
        this.head = new Point3D(head);
    }

    public Vector getDirection() {
        return new Vector(direction);
    }

    public void setDirection(Vector direction) {
        this.direction = new Vector(direction);
    }
}