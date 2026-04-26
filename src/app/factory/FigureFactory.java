package app.factory;

import app.model.Figure;
import java.awt.Color;
import java.util.List;

public interface FigureFactory {
    int requiredPoints();
    Figure create(List<int[]> points, Color color);
    Figure createPreview(List<int[]> points, int x, int y, Color c);
}