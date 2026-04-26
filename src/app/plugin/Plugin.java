package app.plugin;

import app.factory.FigureFactory;
import app.view.Renderer;

public interface Plugin {
    String getName();
    FigureFactory getFactory();

    void register(Renderer renderer);
}
