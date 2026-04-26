package api;

public interface Plugin {

    String getName();

    FigureFactory getFactory(); // may be null

    void register(DrawerRegistry registry);

    DataProcessor getProcessor();
}