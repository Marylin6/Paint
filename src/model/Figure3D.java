package model;

import java.awt.Color;

public abstract class Figure3D extends Figure {
    public int x, y, width, height;

    public Figure3D(int x, int y, int width, int height, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}