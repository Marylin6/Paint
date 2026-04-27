package app.io;

import api.Figure;
import api.FigureLoader;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Serializer {

    private final Map<String, FigureLoader> loaders = new HashMap<>();

    public void register(String type, FigureLoader loader) {
        loaders.put(type, loader);
    }

    public String serialize(List<Figure> figures) {

        StringBuilder sb = new StringBuilder();

        sb.append("<figures>\n");

        for (Figure f : figures) {

            sb.append("    <").append(f.getType());

            for (var entry : f.getData().entrySet()) {
                sb.append(" ")
                        .append(entry.getKey())
                        .append("='")
                        .append(entry.getValue())
                        .append("'");
            }

            sb.append(" color='")
                    .append(f.color.getRGB())
                    .append("'");

            sb.append("/>\n");
        }

        sb.append("</figures>");

        return sb.toString();
    }

    public List<Figure> deserialize(String xml) {

        List<Figure> figures = new ArrayList<>();

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document doc = builder.parse(
                    new ByteArrayInputStream(
                            xml.getBytes(StandardCharsets.UTF_8)
                    )
            );

            NodeList nodes = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {

                if (!(nodes.item(i) instanceof Element el))
                    continue;

                String type = el.getTagName();

                FigureLoader loader = loaders.get(type);

                if (loader != null) {
                    figures.add(loader.load(el));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return figures;
    }
}