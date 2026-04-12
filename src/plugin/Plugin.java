package plugin;

import factory.FigureFactory;
import view.Renderer;

import javax.swing.*;

public interface Plugin {
    String getName();
    FigureFactory getFactory();

    void register(Renderer renderer);
}
