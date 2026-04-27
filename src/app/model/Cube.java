package app.model;

import api.Figure;

import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;

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
    @Override
    public String getType() {
        return "cube";
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("x", String.valueOf(x));
        map.put("y", String.valueOf(y));
        map.put("width", String.valueOf(width));
        map.put("height", String.valueOf(height));
        map.put("dx", String.valueOf(dx));
        map.put("dy", String.valueOf(dy));

        return map;
    }
}