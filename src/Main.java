import controller.Controller;
import factory.*;
import model.Figure;
import view.MainPanel;

import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Figure> figures = new ArrayList<>();
        JFrame frame = new JFrame("Editor");
        MainPanel panel = new MainPanel(figures);
        FigureFactory factory = new CubeFactory();

        Controller contr = new Controller(figures, factory, panel);
        panel.addMouseListener(contr);
        panel.addMouseMotionListener(contr);

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}