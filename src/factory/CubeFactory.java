package factory;

import model.*;
import java.awt.Color;
import java.util.List;

public class CubeFactory implements FigureFactory {

    public int requiredPoints() { return 3; }

    public Figure create(List<int[]> p, Color c) {

        int[] p1 = p.get(0);
        int[] p2 = p.get(1);
        int[] p3 = p.get(2);

        double size = Math.hypot(p2[0]-p1[0], p2[1]-p1[1]);
        double z = Math.hypot(p3[0]-p1[0], p3[1]-p1[1]);

        return new Cube(p1[0], p1[1], z, size, c);
    }
}