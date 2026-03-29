package view;

import factory.*;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Toolbar extends JPanel {
    private JButton selected;

    public Toolbar(Controller controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(60, 60, 60));
        //setBackground(Color.DARK_GRAY);

        add(createButton("/resources/line.png",
                () -> controller.setFactory(new LineFactory())));

        add(createButton("/resources/tri.png",
                () -> controller.setFactory(new TriangleFactory())));

        add(createButton("/resources/sq.png",
                () -> controller.setFactory(new RectangleFactory())));

        add(createButton("/resources/cube.png",
                () -> controller.setFactory(new CubeFactory())));

        add(createButton("/resources/tetra.png",
                () -> controller.setFactory(new TetrahedronFactory())));
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

}