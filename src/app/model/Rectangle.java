package app.model;

import java.awt.*;

public class Rectangle extends Figure{
    public int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
