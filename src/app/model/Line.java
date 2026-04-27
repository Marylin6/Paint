package app.model;

import api.Figure;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Line extends Figure {
    public int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2, Color c) {
        super(c);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String getType() {
        return "line";
    }

    @Override
    public Map<String,String> getData() {

        Map<String,String> map = new HashMap<>();

        map.put("x1", x1 + "");
        map.put("y1", y1 + "");
        map.put("x2", x2 + "");
        map.put("y2", y2 + "");

        return map;
    }
}