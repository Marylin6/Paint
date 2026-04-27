package api;

import java.awt.Graphics;

public interface DrawerRegistry {

    void registerDrawer(Class<? extends Figure> clazz, Drawer drawer);

    interface Drawer {
        void draw(Graphics g, Object figure);
    }
}