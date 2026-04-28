package api;

public interface SerializerRegistry {

    void register(String type, FigureLoader loader);
}