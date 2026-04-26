package app.factory;

import app.model.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class TriangleFactory implements FigureFactory {
    public int requiredPoints() { return 3; }

    public Figure create(List<int[]> p, Color c) {
        return new Triangle(p.get(0)[0], p.get(0)[1], p.get(1)[0], p.get(1)[1], p.get(2)[0], p.get(2)[1], c);
    }

    @Override
    public Figure createPreview(List<int[]> points, int x, int y, Color c) {
        List<int[]> temp = new ArrayList<>(points);
        temp.add(new int[]{x, y});

        if (temp.size() == 2) {
            int[] p1 = temp.get(0);
            int[] p2 = temp.get(1);
            return new Line(p1[0], p1[1], p2[0], p2[1], c);
        }
        if (temp.size() == 3) {
            return create(temp, c);
        }
        return null;
    }
}