package view;

import model.*;
import model.Rectangle;
import util.Projection;

import java.awt.*;

public class Renderer {

    public void draw(Graphics g, Figure f) {

        g.setColor(f.color);

        if (f instanceof Line l) {
            g.drawLine(l.x1, l.y1, l.x2, l.y2);
        }
        if (f instanceof Rectangle r) {
            g.drawRect(r.x, r.y, r.width, r.height);
        }
        if (f instanceof Cube c) {
            int x = c.x;
            int y = c.y;
            int w = c.width;
            int h = c.height;
            int dx = c.dx;
            int dy = c.dy;

            // передняя грань
            g.drawRect(x, y, w, h);

            // задняя грань
            g.drawRect(x + dx, y + dy, w, h);

            // рёбра
            g.drawLine(x, y, x + dx, y + dy);
            g.drawLine(x + w, y, x + w + dx, y + dy);
            g.drawLine(x, y + h, x + dx, y + h + dy);
            g.drawLine(x + w, y + h, x + w + dx, y + h + dy);
        }

    }
}