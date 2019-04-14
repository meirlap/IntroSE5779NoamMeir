package geometries;

public abstract class  RadialGeometry implements IGeometry {
    double _radius;

    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }
    public RadialGeometry(RadialGeometry shape) {
        this._radius = shape._radius;
    }
    public double get_radius() {
        return _radius;
    }
}
