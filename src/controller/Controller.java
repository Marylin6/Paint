package controller;

import factory.FigureFactory;
import model.Figure;
import view.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Controller extends MouseAdapter {

    private enum Mode {
        FIRST_POINT,
        SECOND_POINT,
        THIRD_POINT
    }
    private Mode mode = Mode.FIRST_POINT;

    private List<Figure> figures;
    private List<int[]> points = new ArrayList<>();

    private FigureFactory factory;
    private MainPanel panel;
    private Color color = Color.BLACK;

    private boolean horizontal;

    public Controller(List<Figure> figures, FigureFactory factory, MainPanel panel) {
        this.figures = figures;
        this.factory = factory;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (mode == Mode.FIRST_POINT) {
            points.clear();
            points.add(new int[]{x, y});
            mode = Mode.SECOND_POINT;
        }
        else if (mode == Mode.SECOND_POINT) {
            int[] p1 = points.get(0);
            int dx = x - p1[0];
            int dy = y - p1[1];

            horizontal = Math.abs(dx) > Math.abs(dy);

            if (horizontal) y = p1[1];
            else x = p1[0];

            points.add(new int[]{x, y});
            mode = Mode.THIRD_POINT;
        }
        else if (mode == Mode.THIRD_POINT) {
            int[] p1 = points.get(0);

            if (horizontal) {
                x = p1[0];
            } else {
                y = p1[1];
            }
            points.add(new int[]{x, y});

            figures.add(factory.create(points, color));
            points.clear();
            mode = Mode.FIRST_POINT;
            panel.preview = null;
            panel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if (mode == Mode.FIRST_POINT) return;

        List<int[]> temp = new ArrayList<>(points);

        int x = e.getX();
        int y = e.getY();

        if (mode == Mode.SECOND_POINT) {
            int[] p1 = points.get(0);

            int dx = x - p1[0];
            int dy = y - p1[1];

            boolean hor = Math.abs(dx) > Math.abs(dy);

            if (hor) y = p1[1];
            else x = p1[0];

            temp.add(new int[]{x, y});

            int x1 = p1[0];
            int y1 = p1[1];

            int rx = Math.min(x1, x);
            int ry = Math.min(y1, y);
            int w = Math.abs(x - x1);
            int h = Math.abs(y - y1);

            panel.preview = new model.Rectangle(rx, ry, w, h, color);
        }
        else if (mode == Mode.THIRD_POINT) {
            int[] p1 = points.get(0);

            if (horizontal) x = p1[0];
            else y = p1[1];

            temp.add(new int[]{x, y});

            if (temp.size() == factory.requiredPoints()) {
                panel.preview = factory.create(temp, color);
            }
        }
        panel.repaint();
    }
}