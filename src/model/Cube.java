package model;

import java.awt.Color;

public class Cube extends Figure3D {

    public double size;

    public Cube(double x, double y, double z, double size, Color c) {
        super(x, y, z, c);
        this.size = size;
    }

    @Override
    public double[][] getVertices() {
        return new double[][] {
                {x, y, z},
                {x+size, y, z},
                {x+size, y+size, z},
                {x, y+size, z},
                {x, y, z+size},
                {x+size, y, z+size},
                {x+size, y+size, z+size},
                {x, y+size, z+size}
        };
    }
}