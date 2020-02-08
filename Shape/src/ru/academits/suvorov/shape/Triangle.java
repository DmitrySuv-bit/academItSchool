package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.ShapeInterface;

public class Triangle implements ShapeInterface {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        double max = x1;
        if (max < x2) {
            max = x2;
        }
        if (max < x3) {
            max = x3;
        }

        double min = x1;
        if (min > x2) {
            min = x2;
        }
        if (min > x3) {
            min = x3;
        }

        return max - min;
    }

    @Override
    public double getHeight() {
        double max = y1;
        if (max < y2) {
            max = y2;
        }
        if (max < y3) {
            max = y3;
        }

        double min = y1;
        if (min > y2) {
            min = y2;
        }
        if (min > y3) {
            min = y3;
        }
        return max - min;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
