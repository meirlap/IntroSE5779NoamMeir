package elements;

import primitives.*;

import java.util.Objects;

public class Camera {

    // Eye point of the camera
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vTo;

    // Should be calculated as the cross product if vUp and vTo
    private Vector _vRight;

    public Camera(Point3D P0, Vector vUp, Vector vTo) {
        _P0 = new Point3D(P0);
        _vUp = new Vector(vUp);
        _vTo = new Vector(vTo);

        _vRight = new Vector(_vUp.crossProduct(_vTo));
       // _vUp = _vTo.crossProduct(_vRight);

        _vRight.normalize();
        _vUp.normalize();
        _vTo.normalize();
    }
    public Camera(Camera other){
        _P0     = other.get_P0();
        _vUp    = other.get_vUp();
        _vTo    = other.get_vTo();
        _vRight = other.get_vRight();

    }
    public Camera(){

        _P0 = new Point3D(0, 0, 10);
        _vUp = new Vector(1.0, 0.0, 0.0);
        _vTo = new Vector(0.0, 0.0, -1.0);

        _vRight = _vUp.crossProduct(_vTo);
    }

    public Camera(Vector vup, Vector vto) {
        this(new Point3D(),vup,vto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Camera)) return false;
        Camera camera = (Camera) o;
        return get_P0().equals(camera.get_P0()) &&
                get_vUp().equals(camera.get_vUp()) &&
                get_vTo().equals(camera.get_vTo()) &&
                get_vRight().equals(camera.get_vRight());
    }

    @Override
    public String toString() {
        return "Camera{" +
                "_P0=" + get_P0() +
                ", _vUp=" + get_vUp() +
                ", _vTo=" + get_vTo() +
                ", _vRight=" + get_vRight() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_P0(), get_vUp(), get_vTo(), get_vRight());
    }

    public Point3D get_P0() {
        return _P0;
    }

    public void set_P0(Point3D _P0) {
        this._P0 = _P0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public void set_vUp(Vector _vUp) {
        this._vUp = _vUp;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public void set_vTo(Vector _vTo) {
        this._vTo = _vTo;
    }

    public Vector get_vRight() {
        return _vRight;
    }

    public void set_vRight(Vector _vRight) {
        this._vRight = _vRight;
    }

    /**
     *
     * @param Nx number of pixels by cell
     * @param Ny
     * @param x
     * @param y
     * @param screenDist
     * @param screenWidth
     * @param screenHeight
     * @return
     */
    public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
                                         double screenDist, double screenWidth,
                                         double screenHeight){

        // Calculating the image center
        Vector vToward = new Vector(_vTo);
        Vector vRight = new Vector(_vRight);
        Vector vUP = new Vector(_vUp);

        vToward.normalize();
        vRight.normalize();
        vUP.normalize();

        vToward.scale(screenDist);

        Point3D Pc = get_P0().addVector(vToward);

        // Calculating x-y ratios
        double Rx = screenWidth  / Nx;
        double Ry = screenHeight / Ny;

        // Calculating P - the intersection point
        vRight.scale(((x - (Nx / 2.0)) * Rx + (Rx / 2.0)));
        vUP.scale(-((y - (Ny / 2.0)) * Ry + (Ry / 2.0)));

        Point3D P = (Pc.addVector(vRight)).addVector(vUP);

        // returning the constructed ray between P0 and the intersection point
        return new Ray(P, new Vector(get_P0(), P));
    }
}
