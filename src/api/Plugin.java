package api;

public interface Plugin {

    String getName();
    FigureFactory getFactory();
    void register(DrawerRegistry registry);
}