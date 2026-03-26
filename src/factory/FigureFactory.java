package factory;

import model.Figure;
import java.awt.Color;
import java.util.List;

public interface FigureFactory {
    int requiredPoints();
    Figure create(List<int[]> points, Color color);
}