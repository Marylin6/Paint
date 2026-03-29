package model;

import java.awt.Color;

public class Cube extends Figure {
    public int x, y, width, height, dx, dy;
    public Cube(int x, int y, int width, int height, int dx, int dy, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = dx;
        this.dy = dy;
    }
}