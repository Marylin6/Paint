package factory;

import model.*;
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
}