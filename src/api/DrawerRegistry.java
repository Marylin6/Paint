package api;

import app.model.Figure;

import java.awt.Graphics;

public interface DrawerRegistry {

    void register(Class<? extends Figure> clazz, Drawer drawer);

    interface Drawer {
        void draw(Graphics g, Object figure);
    }
}