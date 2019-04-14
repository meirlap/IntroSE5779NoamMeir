package primitives;

import java.util.Objects;

public class Ray {
    Vector head;
  Point3D  tail;

    public Ray(){
        this.head = new Vector();
        this.tail = new Point3D();
    }

    public Ray(Vector head, Point3D teal) {
        this.setHead(head);
        this.setTail(teal);
    }
    public Ray(Ray r){
        this.setTail(r.getTail());
        this.setHead(r.getHead());
    }
    /************** Getters/Setters *******/

    public Vector getHead() {
        return new Vector(this.head);
    }

    public void setHead(Vector head) {
        this.head = new Vector(head);
    }

    public Point3D getTail() {
        return new Point3D(this.tail);
    }

    public void setTail(Point3D tail) {
        this.tail = new Point3D(tail);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return Objects.equals(getHead(), ray.getHead()) &&
                Objects.equals(getTail(), ray.getTail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead(), getTail());
    }
}
