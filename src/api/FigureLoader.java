package api;

import org.w3c.dom.Element;

public interface FigureLoader {
    Figure load(Element el);
}