package ru.academits.suvorov.shape_main;

import ru.academits.suvorov.shape_interface.ShapeInterface;
import ru.academits.suvorov.shape.*;

import java.util.Arrays;

public class ShapeMain {
    public static void main(String[] args) {
        ShapeInterface[] shapes = new ShapeInterface[]{
                new Square(50),
                new Square(50),
                new Square(50),
                new Rectangle(50, 50),
                new Rectangle(6, 7),
                new Rectangle(8, 9),
                new Circle(10),
                new Circle(10),
                new Circle(10),
                new Triangle(2, 2, 4, 6, 7, 3),
                new Triangle(4, 3, 9, 6, 9, 3),
                new Triangle(11, 2, 15, 5, 17, 2)
        };
        /*Square[] squares = new Square[]{new Square(5), new Square(9), new Square(7)};

        Rectangle[] rectangles = new Rectangle[]{new Rectangle(4, 5), new Rectangle(6, 7), new Rectangle(8, 9)};

        Triangle[] triangles = new Triangle[]{new Triangle(2, 2, 4, 6, 7, 3), new Triangle(4, 3, 9, 6, 9, 3), new Triangle(11, 2, 15, 5, 17, 2)};

        Circle[] circles = new Circle[]{new Circle(8),new Circle(9), new Circle(10)};*/

        ShapesList list = new ShapesList();

        /*for (int i = 0; i < shapes.length - 1; ++i) {
            list.addShapes(shapes[i]);
        }*/

        list.printArea(shapes);
        System.out.println();

        list.sortShapes(shapes);

        int[] maxArea = list.shapeMaxArea(shapes);

        System.out.println(Arrays.toString(maxArea));

        /*for (ShapeInterface value : shape) {
            System.out.println("Параметры фигуры " + value.getClass().getSimpleName() + ":");
            System.out.println("Ширина: " + value.getWidth());
            System.out.println("Высота: " + value.getHeight());
            System.out.println("Площадь: " + value.getArea());
            System.out.println("Периметр: " + value.getPerimeter());
            System.out.println();
        }*/
    }
}