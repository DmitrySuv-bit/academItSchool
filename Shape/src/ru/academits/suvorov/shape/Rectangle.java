package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.Shape;

public class Rectangle implements Shape {
    private double rectangleWidth;
    private double rectangleHeight;

    public Rectangle(double width, double height) {
        this.rectangleWidth = width;
        this.rectangleHeight = height;
    }

    private void setRectangleWidth(double rectangleWidth) {
        this.rectangleWidth = rectangleWidth;
    }

    private void setRectangleHeight(double rectangleHeight) {
        this.rectangleHeight = rectangleHeight;
    }

    public double getRectangleWidth() {
        return rectangleWidth;
    }

    public double getRectangleHeight() {
        return rectangleHeight;
    }

    @Override
    public String toString() {
        return "Shape: Rectangle - Width = " + rectangleWidth + ", Height = " + rectangleHeight + ", Area = " + getArea() + ", Perimeter = " + getPerimeter() + ", Width = " + getWidth() + ", Height = " + getHeight();
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

        return rectangle.rectangleWidth == rectangleWidth && rectangle.rectangleHeight == rectangleHeight;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(rectangleWidth);
        hash = prime * hash + Double.hashCode(rectangleHeight);

        return hash;
    }

    @Override
    public double getWidth() {
        return rectangleWidth;
    }

    @Override
    public double getHeight() {
        return rectangleHeight;
    }

    @Override
    public double getArea() {
        return rectangleWidth * rectangleHeight;
    }

    @Override
    public double getPerimeter() {
        return (rectangleWidth + rectangleHeight) * 2;
    }
}