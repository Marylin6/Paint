package plugin;

import factory.FigureFactory;
import model.Figure;

import javax.swing.*;

public interface Plugin {
    String getName();
    FigureFactory getFactory();
    void draw(java.awt.Graphics g, Figure f);
    Icon getIcon();
}
