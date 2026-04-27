package app.factory;

import api.Figure;
import api.FigureFactory;
import app.model.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class TetrahedronFactory implements FigureFactory {

    public int requiredPoints() { return 4; }

    public Figure create(List<int[]> p, Color c) {
        int[] p1 = p.get(0);
        int[] p2 = p.get(1);
        int[] p3 = p.get(2);
        int[] p4 = p.get(3);

        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        int x3 = p3[0], y3 = p3[1];
        int x4 = p4[0], y4 = p4[1];

        return new Tetrahedron(x1,y1,x2,y2,x3,y3,x4,y4,c);
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
            int[] p1 = temp.get(0);
            int[] p2 = temp.get(1);
            int[] p3 = temp.get(2);

            return new Triangle(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1], c);
        }

        if (temp.size() == 4) {
            return create(temp, c);
        }

        return null;
    }
}