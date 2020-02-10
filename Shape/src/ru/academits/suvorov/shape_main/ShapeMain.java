package ru.academits.suvorov.shape_main;

import ru.academits.suvorov.shape_comparator.AreaComparator;
import ru.academits.suvorov.shape_comparator.PerimeterComparator;
import ru.academits.suvorov.shape_interface.ShapeInterface;

import ru.academits.suvorov.shape.*;

import java.util.Arrays;

public class ShapeMain {
    public static void main(String[] args) {
        ShapeInterface[] shapes = new ShapeInterface[]{
                new Square(20),
                new Square(6),
                new Square(7),
                new Rectangle(7, 7),
                new Rectangle(20, 20),
                new Rectangle(10, 10),
                new Circle(8),
                new Circle(10),
                new Circle(10),
                new Triangle(2, 2, 4, 6, 7, 3),
                new Triangle(4, 3, 9, 6, 9, 3),
                new Triangle(11, 2, 15, 5, 17, 2)
        };

        Arrays.sort(shapes, new AreaComparator());

        System.out.println("Фигуры с максимальной площадью: ");
        System.out.println();

        for (int i = shapes.length - 1; i >= 0; --i) {
            System.out.println(shapes[i]);
            System.out.println();

            if (shapes[i].getArea() != shapes[i - 1].getArea()) {
                break;
            }
        }

        Arrays.sort(shapes, new PerimeterComparator());

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
}