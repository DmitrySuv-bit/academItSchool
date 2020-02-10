package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.ShapeInterface;

import java.util.Objects;

public class Square implements ShapeInterface {
    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shape: Square\n" + "Size = " + size + "\nArea = " + getArea() + "\nPerimeter = " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public double getWidth() {
        return size;
    }

    @Override
    public double getHeight() {
        return size;
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public double getPerimeter() {
        return size * 4;
    }
}