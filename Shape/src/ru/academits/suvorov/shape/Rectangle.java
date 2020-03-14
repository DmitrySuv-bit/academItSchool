package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.Shape;

public class Rectangle implements Shape {
    private double Width;
    private double Height;

    public Rectangle(double width, double height) {
        this.Width = width;
        this.Height = height;
    }

    private void setWidth(double width) {
        this.Width = width;
    }

    private void setHeight(double height) {
        this.Height = height;
    }

    @Override
    public String toString() {
        return "Shape: Rectangle - Width = " + Width + ", Height = " + Height + ", Area = " + getArea()
                + ", Perimeter = " + getPerimeter() + ", Width = " + getWidth() + ", Height = " + getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return rectangle.Width == Width && rectangle.Height == Height;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(Width);
        hash = prime * hash + Double.hashCode(Height);

        return hash;
    }

    @Override
    public double getWidth() {
        return Width;
    }

    @Override
    public double getHeight() {
        return Height;
    }

    @Override
    public double getArea() {
        return Width * Height;
    }

    @Override
    public double getPerimeter() {
        return (Width + Height) * 2;
    }
}