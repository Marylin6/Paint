package app;

import app.controller.Controller;
import app.factory.*;
import api.*;
import app.plugin.BuiltinPlugin;
import app.plugin.PluginLoader;
import app.view.*;
import app.view.Renderer;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Figure> figures = new ArrayList<>();
        JFrame frame = new JFrame("Editor");
        Renderer renderer = new Renderer();
        new BuiltinPlugin().register(renderer);

        List<Plugin> plugins = PluginLoader.loadPlugins(System.getProperty("user.dir") + "/plugins");
        for (Plugin p : plugins) {
            p.register(renderer);
        }

        MainPanel panel = new MainPanel(figures, renderer);

        Controller contr = new Controller(figures, new LineFactory(), panel);
        panel.addMouseMotionListener(contr);
        panel.addMouseListener(contr);

        Toolbar toolbar = new Toolbar(contr, plugins);

        frame.setLayout(new BorderLayout());
        frame.add(toolbar, BorderLayout.WEST);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}