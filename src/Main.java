import controller.Controller;
import factory.*;
import model.Figure;
import plugin.Plugin;
import plugin.PluginLoader;
import view.MainPanel;
import view.Toolbar;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Figure> figures = new ArrayList<>();
        JFrame frame = new JFrame("Editor");
        MainPanel panel = new MainPanel(figures);

        Controller contr = new Controller(figures, new LineFactory(), panel);
        panel.addMouseMotionListener(contr);
        panel.addMouseListener(contr);

        String path = System.getProperty("user.dir") + "\\plugins";
        List<Plugin> plugins = PluginLoader.loadPlugins(path);
        Toolbar toolbar = new Toolbar(contr, plugins);

        frame.setLayout(new BorderLayout());
        frame.add(toolbar, BorderLayout.WEST);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}