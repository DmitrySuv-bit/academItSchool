package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_interface.ShapeInterface;

public class Circle implements ShapeInterface {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Shape: Circle - " + "radius = " + radius + ", Area = " + getArea() + ", Perimeter = " + getPerimeter() + ", Width = " + getWidth() + ", Height = " + getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;

        return circle.radius == radius;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(radius);

        return hash;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }
}