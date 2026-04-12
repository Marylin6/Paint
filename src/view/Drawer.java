package view;

import model.Figure;
import java.awt.Graphics;

public interface Drawer {
    void draw(Graphics g, Figure f);
}