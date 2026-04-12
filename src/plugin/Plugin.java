package plugin;

import factory.FigureFactory;

public interface Plugin {
    String getName();
    FigureFactory getFactory();
}
