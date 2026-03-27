package view;

import factory.*;
import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {

    public Toolbar(Controller controller) {

        setLayout(new GridLayout(0, 1)); // вертикально

        JButton lineBtn = new JButton("Line");
        JButton rectBtn = new JButton("Rectangle");
        JButton cubeBtn = new JButton("Cube");

        lineBtn.addActionListener(e ->
                controller.setFactory(new LineFactory()));

        rectBtn.addActionListener(e ->
                controller.setFactory(new RectangleFactory()));

        cubeBtn.addActionListener(e ->
                controller.setFactory(new CubeFactory()));

        add(lineBtn);
        add(rectBtn);
        add(cubeBtn);
    }
}