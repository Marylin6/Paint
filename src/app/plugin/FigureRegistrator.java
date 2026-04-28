package app.plugin;

import app.io.Serializer;
import app.model.*;

import java.awt.Color;

public class FigureRegistrator {

    public static void registerBuiltins(Serializer serializer) {

        serializer.register("line", el ->
                new Line(
                        get(el,"x1"),
                        get(el,"y1"),
                        get(el,"x2"),
                        get(el,"y2"),
                        color(el)
                )
        );

        serializer.register("rectangle", el ->
                new Rectangle(
                        get(el,"x"),
                        get(el,"y"),
                        get(el,"width"),
                        get(el,"height"),
                        color(el)
                )
        );

        serializer.register("triangle", el ->
                new Triangle(
                        get(el,"x1"), get(el,"y1"),
                        get(el,"x2"), get(el,"y2"),
                        get(el,"x3"), get(el,"y3"),
                        color(el)
                )
        );

        serializer.register("cube", el ->
                new Cube(
                        get(el,"x"),
                        get(el,"y"),
                        get(el,"width"),
                        get(el,"height"),
                        get(el,"dx"),
                        get(el,"dy"),
                        color(el)
                )
        );

        serializer.register("tetrahedron", el ->
                new Tetrahedron(
                        get(el,"x1"), get(el,"y1"),
                        get(el,"x2"), get(el,"y2"),
                        get(el,"x3"), get(el,"y3"),
                        get(el,"x4"), get(el,"y4"),
                        color(el)
                )
        );
    }

    private static int get(org.w3c.dom.Element el, String name) {
        return Integer.parseInt(el.getAttribute(name));
    }

    private static Color color(org.w3c.dom.Element el) {
        return new Color(
                Integer.parseInt(el.getAttribute("color")),
                true
        );
    }
}