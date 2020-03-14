package ru.academits.suvorov.shape_main;

import ru.academits.suvorov.shape_comparator.AreaComparator;
import ru.academits.suvorov.shape_comparator.PerimeterComparator;
import ru.academits.suvorov.shape_interface.Shape;
import ru.academits.suvorov.shape.*;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeMain {
    public static void printShapesWithMaxArea(Shape[] shapes, Comparator<Shape> comparator) {
        Arrays.sort(shapes, comparator);

        System.out.println("Фигуры с максимальной площадью: ");
        System.out.println();

        for (int i = shapes.length - 1; i >= 0; --i) {
            System.out.println(shapes[i]);
            System.out.println();

            if (shapes[i].getArea() != shapes[i - 1].getArea()) {
                break;
            }
        }
    }

    public static void printShapesWithSecondPerimeter(Shape[] shapes, Comparator<Shape> comparator) {
        Arrays.sort(shapes, comparator);

        System.out.println("Фигуры со вторым по величине периметром: ");
        System.out.println();

        boolean isMax = true;

        for (int i = shapes.length - 1; i >= 0; --i) {
            if (isMax) {
                if (shapes[i].getPerimeter() != shapes[i - 1].getPerimeter()) {
                    isMax = false;
                }
            } else {
                System.out.println(shapes[i]);
                System.out.println();

                if (shapes[i].getPerimeter() != shapes[i - 1].getPerimeter()) {
                    break;
                }
            }
        }
    }

    public static void printShapes(Shape[] shapes) {
        System.out.println("Все фигуры: ");

        for (Shape e : shapes) {
            System.out.println(e);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(20),
                new Square(20),
                new Square(7),
                new Rectangle(7, 7),
                new Rectangle(20, 15),
                new Rectangle(20, 15),
                new Circle(8),
                new Circle(10),
                new Circle(10),
                new Triangle(2, 2, 4, 6, 7, 3),
                new Triangle(4, 3, 9, 6, 9, 3),
                new Triangle(11, 2, 15, 5, 17, 2)
        };

        printShapesWithMaxArea(shapes, new AreaComparator());

        printShapesWithSecondPerimeter(shapes, new PerimeterComparator());

        printShapes(shapes);
    }
}