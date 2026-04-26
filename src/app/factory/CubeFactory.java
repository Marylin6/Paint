package app.factory;

import app.model.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CubeFactory implements FigureFactory {

    public int requiredPoints() { return 3; }

    public Figure create(List<int[]> p, Color c) {
        int x1 = p.get(0)[0];
        int y1 = p.get(0)[1];
        int x2 = p.get(1)[0];
        int y2 = p.get(1)[1];
        int x3 = p.get(2)[0];
        int y3 = p.get(2)[1];

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);

        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        int dx = x3 - x1;
        int dy = y3 - y1;
        return new Cube(x, y, width, height, dx, dy, c);
    }

    @Override
    public Figure createPreview(List<int[]> points, int x, int y, Color c) {
        List<int[]> temp = new ArrayList<>(points);
        temp.add(new int[]{x, y});

        if (temp.size() == 2) {
            int[] p1 = temp.get(0);
            int[] p2 = temp.get(1);

            int rx = Math.min(p1[0], p2[0]);
            int ry = Math.min(p1[1], p2[1]);
            int w = Math.abs(p2[0] - p1[0]);
            int h = Math.abs(p2[1] - p1[1]);

            return new Rectangle(rx, ry, w, h, c);
        }
        if (temp.size() == 3) {
            return create(temp, c);
        }

        return null;
    }
}