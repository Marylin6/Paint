package model;

import java.awt.Color;

public class Cube extends Figure3D {
    public int dx;
    public int dy;
    public Cube(int x, int y, int width, int height, int dx, int dy, Color c) {
        super(x, y, width, height, c);
        this.dx = dx;
        this.dy = dy;
    }
}