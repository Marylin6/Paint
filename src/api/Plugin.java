package api;

import app.io.Serializer;

public interface Plugin {

    String getName();
    FigureFactory getFactory();
    void register(DrawerRegistry registry);
    void registerSerializer(SerializerRegistry serializer);
}