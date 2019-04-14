package geometries;

import primitives.*;


public  abstract class FlatGeometry implements IGeometry {
    public abstract Vector  getNormal(Point3D p);
}
