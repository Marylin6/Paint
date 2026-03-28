package view;

import factory.*;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Toolbar extends JPanel {
    private JButton selected;
    private final Color ACTIVE_COLOR = new Color(180, 200, 255);

    public Toolbar(Controller controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setBackground(Color.DARK_GRAY);

        add(createButton("/resources/line.png",
                () -> controller.setFactory(new LineFactory())));

        add(createButton("/resources/tri.png",
                () -> controller.setFactory(new TriangleFactory())));

        add(createButton("/resources/sq.png",
                () -> controller.setFactory(new RectangleFactory())));

        add(createButton("/resources/cube.png",
                () -> controller.setFactory(new CubeFactory())));
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

            btn.setContentAreaFilled(true);
            btn.setOpaque(true);

            btn.setBorderPainted(true);

            btn.setBackground(getBackground());

            btn.setAlignmentX(Component.CENTER_ALIGNMENT);

            btn.addActionListener(e -> {

                if (selected != null) {
                    selected.setBackground(getBackground());
                }

                btn.setBackground(ACTIVE_COLOR);
                selected = btn;

                action.run();
            });

            return btn;

    }
}