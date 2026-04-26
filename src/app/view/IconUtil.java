package app.view;

import javax.swing.*;
import java.net.URL;

public class IconUtil {

    public static ImageIcon load(String path) {
        URL url = IconUtil.class.getResource(path);
        if (url == null) {
            throw new RuntimeException("Icon not found: " + path);
        }
        return new ImageIcon(url);
    }
}
