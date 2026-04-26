package api;

public interface DataProcessor {

    String getName();

    String processBeforeSave(String data);

    String processAfterLoad(String data);
}