package factory;

import model.*;
import java.awt.Color;
import java.util.List;

public class RectangleFactory implements FigureFactory{
    public int requiredPoints() { return 2; }

    public Figure create(List<int[]> p, Color c) {
        int x1 = p.get(0)[0];
        int y1 = p.get(0)[1];
        int x2 = p.get(1)[0];
        int y2 = p.get(1)[1];

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);

        int w = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);

        return new Rectangle(x, y, w, h, c);
    }

    @Override
    public Figure createPreview(List<int[]> points, int x, int y, Color c) {

        int[] p1 = points.get(0);

        int rx = Math.min(p1[0], x);
        int ry = Math.min(p1[1], y);
        int w = Math.abs(x - p1[0]);
        int h = Math.abs(y - p1[1]);

        return new Rectangle(rx, ry, w, h, c);
    }
}
