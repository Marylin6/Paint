package view;

import model.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class MainPanel extends JPanel {

    private List<Figure> figures;
    private Renderer renderer = new Renderer();

    public Figure preview;

    // размеры холста
    private final int canvasWidth = 900;
    private final int canvasHeight = 700;

    public MainPanel(List<Figure> figures) {
        this.figures = figures;
        setBackground(new Color(60, 60, 60));
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = Math.max((getWidth() - canvasWidth) / 2, 0);
        int y = Math.max((getHeight() - canvasHeight) / 2, 0);

        g2.setColor(new Color(0, 0, 0, 50));
        g2.fillRect(x + 10, y + 10, canvasWidth, canvasHeight);

        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, canvasWidth, canvasHeight);

        Shape oldClip = g2.getClip();
        g2.setClip(x, y, canvasWidth, canvasHeight);

        for (Figure f : figures) {
            renderer.draw(g2, f);
        }
        if (preview != null)
            renderer.draw(g2, preview);
        g2.setClip(oldClip);

        g2.dispose();
    }
}
