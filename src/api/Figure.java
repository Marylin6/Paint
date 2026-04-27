package api;

import java.awt.*;
import java.util.Map;

public abstract class Figure {
    public Color color;
    public Figure(Color color) {
        this.color = color;
    }
    public abstract String getType();
    public abstract Map<String, String> getData();
}