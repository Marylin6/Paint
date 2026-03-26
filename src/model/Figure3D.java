package model;

import java.awt.Color;

public abstract class Figure3D extends Figure {
    public int x, y, width, height, depth;

    public Figure3D(double x, double y, double width, double height, double depth, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    //public abstract double[][] getVertices();
}