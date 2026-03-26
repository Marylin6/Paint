package model;

import java.awt.Color;

public abstract class Figure3D extends Figure {
    public double x, y, z;

    public Figure3D(double x, double y, double z, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public abstract double[][] getVertices();
}