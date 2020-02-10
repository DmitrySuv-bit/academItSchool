package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.ShapeInterface;

import java.util.Objects;

public class Rectangle implements ShapeInterface {
    private double size1;
    private double size2;

    public Rectangle(double size1, double size2) {
        this.size1 = size1;
        this.size2 = size2;
    }

    @Override
    public String toString() {
        return "Shape: Rectangle\n" + "Size 1 = " + size1 + ", Size 2 = " + size2 + "\nArea = " + getArea() + "\nPerimeter = " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.size1, size1) == 0 &&
                Double.compare(rectangle.size2, size2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size1, size2);
    }

    @Override
    public double getWidth() {
        return Math.max(size1, size2);
    }

    @Override
    public double getHeight() {
        return Math.min(size1, size2);
    }

    @Override
    public double getArea() {
        return size1 * size2;
    }

    @Override
    public double getPerimeter() {
        return (size1 + size2) * 2;
    }
}