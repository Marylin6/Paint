package view;

import model.*;
import model.Rectangle;

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

            g.drawRect(x, y, w, h);
            g.drawRect(x + dx, y + dy, w, h);

            g.drawLine(x, y, x + dx, y + dy);
            g.drawLine(x + w, y, x + w + dx, y + dy);
            g.drawLine(x, y + h, x + dx, y + h + dy);
            g.drawLine(x + w, y + h, x + w + dx, y + h + dy);
        }
        if (f instanceof Triangle t) {
            g.drawLine(t.x1, t.y1, t.x2, t.y2);
            g.drawLine(t.x2, t.y2, t.x3, t.y3);
            g.drawLine(t.x1, t.y1, t.x3, t.y3);
        }
        if (f instanceof Tetrahedron t) {
            g.drawLine(t.x1, t.y1, t.x2, t.y2);
            g.drawLine(t.x2, t.y2, t.x3, t.y3);
            g.drawLine(t.x3, t.y3, t.x1, t.y1);

            g.drawLine(t.x1, t.y1, t.x4, t.y4);
            g.drawLine(t.x2, t.y2, t.x4, t.y4);
            g.drawLine(t.x3, t.y3, t.x4, t.y4);
        }
    }
}