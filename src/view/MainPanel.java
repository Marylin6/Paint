package view;

import model.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {

    private List<Figure> figures;
    private Renderer renderer = new Renderer();

    public Figure preview;

    public MainPanel(List<Figure> figures) {
        this.figures = figures;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Figure f : figures) {
            renderer.draw(g, f);
            if (preview != null)
                renderer.draw(g, preview);
        }
    }
}