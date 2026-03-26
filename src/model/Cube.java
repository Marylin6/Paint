package model;

import java.awt.Color;

public class Cube extends Figure3D {
    public Cube(int x, int y, int width, int height, int depth, Color c) {
        super(x, y, width, height, depth, c);
    }

//    @Override
//    public double[][] getVertices() {
//        return new double[][] {
//                {x, y, z},
//                {x+size, y, z},
//                {x+size, y+size, z},
//                {x, y+size, z},
//                {x, y, z+size},
//                {x+size, y, z+size},
//                {x+size, y+size, z+size},
//                {x, y+size, z+size}
//        };
//    }
}