package app.view;

import api.DrawerRegistry;
import api.Figure;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class Renderer implements DrawerRegistry {

    private final Map<Class<?>, Drawer> drawers = new HashMap<>();

    @Override
    public void registerDrawer(Class<? extends Figure> clazz, Drawer drawer) {
        drawers.put(clazz, drawer);
    }

    public void draw(Graphics g, Figure figure) {

        if (figure == null)
            return;

        g.setColor(figure.color);

        Drawer drawer = drawers.get(figure.getClass());

        if (drawer != null) {
            drawer.draw(g, figure);
        }
    }
}