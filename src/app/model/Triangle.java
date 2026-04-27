package app.model;

import api.Figure;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Triangle extends Figure {
    public int x1, y1;
    public int x2, y2;
    public int x3, y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c) {
        super(c);
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.x3 = x3; this.y3 = y3;
    }
    @Override
    public String getType() {
        return "triangle";
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("x1", String.valueOf(x1));
        map.put("y1", String.valueOf(y1));

        map.put("x2", String.valueOf(x2));
        map.put("y2", String.valueOf(y2));

        map.put("x3", String.valueOf(x3));
        map.put("y3", String.valueOf(y3));

        return map;
    }
}