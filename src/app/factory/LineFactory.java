package app.factory;

import api.*;
import app.model.*;
import java.awt.Color;
import java.util.List;

public class LineFactory implements FigureFactory {

    public int requiredPoints() { return 2; }

    public Figure create(List<int[]> p, Color c) {
        return new Line(
                p.get(0)[0], p.get(0)[1],
                p.get(1)[0], p.get(1)[1],
                c
        );
    }

    public Figure createPreview(List<int[]> points, int x, int y, Color c) {
        int[] p = points.get(0);
        return new Line(x, y, p[0], p[1], c);
    }
}