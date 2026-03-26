package model;

import java.awt.Color;

public abstract class Figure3D extends Figure {
    public int x, y, width, height, depth;

    public Figure3D(int x, int y, int width, int height, int depth, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    //public abstract double[][] getVertices();
}