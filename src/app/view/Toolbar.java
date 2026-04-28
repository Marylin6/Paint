package app.view;

import api.Figure;
import api.Plugin;
import app.factory.*;
import app.controller.Controller;
import app.io.Serializer;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.awt.*;
import java.util.Objects;

public class Toolbar extends JPanel {
    private JButton selected;

    public Toolbar(
            Controller controller,
            List<Plugin> plugins,
            List<Figure> figures,
            MainPanel panel,
            Serializer serializer
    ) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(60, 60, 60));

        for (Plugin plugin : plugins) {

            if (plugin.getFactory() != null) {
                add(createTextButton(plugin.getName(), () -> controller.setFactory(plugin.getFactory())));
            }
        }
        add(createTextButton("Line", () -> controller.setFactory(new LineFactory())));

        add(createTextButton("Triangle", () -> controller.setFactory(new TriangleFactory())));

        add(createTextButton("Square", () -> controller.setFactory(new RectangleFactory())));

        add(createTextButton("Cube", () -> controller.setFactory(new CubeFactory())));

        add(createTextButton("Tetra", () -> controller.setFactory(new TetrahedronFactory())));

        add(Box.createVerticalStrut(20));

        add(createTextButton("Save", () -> {

            JFileChooser chooser = new JFileChooser();

            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = chooser.getSelectedFile();
                    String xml = serializer.serialize(figures);
                    Files.writeString(file.toPath(), xml);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }));

        add(createTextButton("Load", () -> {

            JFileChooser chooser = new JFileChooser();

            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = chooser.getSelectedFile();
                    String xml = Files.readString(file.toPath());
                    figures.clear();
                    figures.addAll(serializer.deserialize(xml));
                    panel.repaint();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }));
    }

    private JButton createButton(String path, Runnable action) {
        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(getClass().getResource(path))
        );

        Image scaled = icon.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        JButton btn = new JButton(new ImageIcon(scaled));

        btn.setPreferredSize(new Dimension(40, 40));
        btn.setMaximumSize(new Dimension(40, 40));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);

        btn.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
        btn.setBackground(new Color(50, 50, 90));

        Color hover = new Color(70, 70, 70);
        Color active = new Color(90, 90, 90);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (btn != selected)
                    btn.setBackground(hover);
                btn.setOpaque(true);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (btn != selected) {
                    btn.setOpaque(false);
                }
            }
        });

        btn.addActionListener(e -> {
            if (selected != null) {
                selected.setOpaque(false);
                selected.repaint();
            }

            btn.setOpaque(true);
            btn.setBackground(active);
            selected = btn;

            action.run();
        });

        return btn;
    }

    private JButton createTextButton(String text, Runnable action) {

        JButton btn = new JButton(text);

        btn.setMaximumSize(new Dimension(80,40));
        btn.setPreferredSize(new Dimension(80,40));

        btn.setFocusPainted(false);
        btn.setBackground(new Color(80,80,80));
        btn.setForeground(Color.WHITE);

        btn.addActionListener(e -> action.run());

        return btn;
    }
}