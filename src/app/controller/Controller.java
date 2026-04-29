package app.controller;

import api.*;
import app.view.MainPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Controller extends MouseAdapter {

    private enum Mode {
        FIRST_POINT,
        SECOND_POINT,
        LAST_POINT
    }
    private Mode mode = Mode.FIRST_POINT;

    private List<Figure> figures;
    private List<int[]> points = new ArrayList<>();

    private FigureFactory factory;
    private MainPanel panel;
    private Color color = Color.BLACK;

    private int secondCounter = 0;

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
            secondCounter = 0;
            mode = Mode.SECOND_POINT;
        }
        else if (mode == Mode.SECOND_POINT) {
            points.add(new int[]{x, y});
            secondCounter++;
            if (factory.requiredPoints() > 2) {
                if (factory.requiredPoints() - secondCounter == 2) {
                    mode = Mode.LAST_POINT;
                }
                panel.preview = factory.createPreview(points, x, y, color);
            }
            else {
                mode = Mode.FIRST_POINT;
                figures.add(factory.create(points, color));
                points.clear();
            }

            panel.repaint();
        }
        else if (mode == Mode.LAST_POINT) {
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

        int x = e.getX();
        int y = e.getY();

        panel.preview = factory.createPreview(points, x, y, color);
        panel.repaint();
    }

    public void setFactory(FigureFactory factory) {
        this.factory = factory;
        points.clear();
        mode = Mode.FIRST_POINT;
        panel.preview = null;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}