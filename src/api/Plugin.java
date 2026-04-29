package api;

public interface Plugin {

    DataProcessor getProcessor();
    String getName();
    FigureFactory getFactory();
    void register(DrawerRegistry registry);
    void registerSerializer(SerializerRegistry serializer);
}