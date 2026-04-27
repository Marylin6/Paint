package app.model;

import api.Figure;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tetrahedron extends Figure {

    public int x1, y1;
    public int x2, y2;
    public int x3, y3;
    public int x4, y4;

    public Tetrahedron(int x1, int y1,
                       int x2, int y2,
                       int x3, int y3,
                       int x4, int y4,
                       Color c) {
        super(c);
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.x3 = x3; this.y3 = y3;
        this.x4 = x4; this.y4 = y4;
    }

    @Override
    public String getType() {
        return "tetrahedron";
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

        map.put("x4", String.valueOf(x4));
        map.put("y4", String.valueOf(y4));

        return map;
    }
}