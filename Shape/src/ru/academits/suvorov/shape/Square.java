package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.ShapeInterface;

public class Square implements ShapeInterface {
    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shape: Square - " + "Size = " + size + ", Area = " + getArea() + ", Perimeter = " + getPerimeter() + ", Width = " + getWidth() + ", Height = " + getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;

        return square.size == size;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(size);

        return hash;
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

    public double getSize() {
        return size;
    }

    private void setSize(double size) {
        this.size = size;
    }
}