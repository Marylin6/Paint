package view;

import model.*;
import util.Projection;

import java.awt.*;

public class Renderer {

    public void draw(Graphics g, Figure f) {

        g.setColor(f.color);

        if (f instanceof Line l) {
            g.drawLine(l.x1, l.y1, l.x2, l.y2);
        }

        if (f instanceof Cube c) {
            int x = c.x;
            int y = c.y;
            int w = c.width;
            int h = c.height;
            int d = c.depth;

            // передняя грань
            g.drawRect(x, y, w, h);

            // задняя грань (смещённая)
            g.drawRect(x + d, y - d, w, h);

            // соединяем углы
            g.drawLine(x, y, x + d, y - d);
            g.drawLine(x + w, y, x + w + d, y - d);
            g.drawLine(x, y + h, x + d, y + h - d);
            g.drawLine(x + w, y + h, x + w + d, y + h - d);
        }
    }
}