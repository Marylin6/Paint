package app.plugin;

import api.DrawerRegistry;
import api.FigureFactory;
import api.Plugin;
import app.model.*;

public class BuiltinPlugin implements Plugin {

    public String getName() {
        return "builtin";
    }

    public FigureFactory getFactory() {
        return null;
    }

    public void register(DrawerRegistry r) {

        r.registerDrawer(Line.class, (g, f) -> {
            Line l = (Line) f;
            g.drawLine(l.x1, l.y1, l.x2, l.y2);
        });

        r.registerDrawer(Rectangle.class, (g, f) -> {
            Rectangle rec = (Rectangle) f;
            g.drawRect(rec.x, rec.y, rec.width, rec.height);
        });

        r.registerDrawer(Triangle.class, (g, f) -> {
            Triangle t = (Triangle) f;
            g.drawLine(t.x1, t.y1, t.x2, t.y2);
            g.drawLine(t.x2, t.y2, t.x3, t.y3);
            g.drawLine(t.x1, t.y1, t.x3, t.y3);
        });

        r.registerDrawer(Cube.class, (g, f) -> {
            Cube c = (Cube) f;

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
        });

        r.registerDrawer(Tetrahedron.class, (g, f) -> {
            Tetrahedron t = (Tetrahedron) f;

            g.drawLine(t.x1, t.y1, t.x2, t.y2);
            g.drawLine(t.x2, t.y2, t.x3, t.y3);
            g.drawLine(t.x3, t.y3, t.x1, t.y1);

            g.drawLine(t.x1, t.y1, t.x4, t.y4);
            g.drawLine(t.x2, t.y2, t.x4, t.y4);
            g.drawLine(t.x3, t.y3, t.x4, t.y4);
        });
    }
}