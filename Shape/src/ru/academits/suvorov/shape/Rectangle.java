package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.ShapeInterface;

public class Rectangle implements ShapeInterface {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getWidth() {
        return Math.max(side1, side2);
    }

    @Override
    public double getHeight() {
        return Math.min(side1, side2);
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2) * 2;
    }
}
