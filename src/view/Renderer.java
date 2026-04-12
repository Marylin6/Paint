package view;

import model.Figure;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Renderer {

    private Map<Class<? extends Figure>, Drawer> drawers = new HashMap<>();

    public void register(Class<? extends Figure> clazz, Drawer drawer) {
        drawers.put(clazz, drawer);
    }

    public void draw(Graphics g, Figure f) {
        g.setColor(f.color);

        Drawer d = drawers.get(f.getClass());

        if (d != null) {
            d.draw(g, f);
        } else {
            System.out.println("No drawer for " + f.getClass());
        }
    }
}