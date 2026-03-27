import controller.Controller;
import factory.*;
import model.Figure;
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


        Toolbar toolbar = new Toolbar(contr);

        frame.setLayout(new BorderLayout());
        frame.add(toolbar, BorderLayout.WEST);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}