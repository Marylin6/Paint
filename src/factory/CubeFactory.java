package factory;

import model.*;
import java.awt.Color;
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

        int depth;
        int dx = x3 - x2;
        int dy = y3 - y2;

        if (Math.abs(dx) > Math.abs(dy)) {
            depth = dx;
        } else {
            depth = dy;
        }

        return new Cube(x, y, width, height, depth, c);
    }
}