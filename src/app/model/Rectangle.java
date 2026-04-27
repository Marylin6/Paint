package app.model;

import api.Figure;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Rectangle extends Figure {
    public int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, Color c) {
        super(c);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    @Override
    public String getType() {
        return "rectangle";
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("x", String.valueOf(x));
        map.put("y", String.valueOf(y));
        map.put("width", String.valueOf(width));
        map.put("height", String.valueOf(height));

        return map;
    }
}
