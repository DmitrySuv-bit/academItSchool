package ru.academits.suvorov.shape;

import ru.academits.suvorov.shape_comparator.AreaComparator;
import ru.academits.suvorov.shape_interface.ShapeInterface;

import java.util.Arrays;

public class ShapesList {
    /*ShapeInterface[] list = new ShapeInterface[100];
    int p;

    public void addShapes(ShapeInterface shape) {
        list[p++] = shape;
    }*/

    public void printArea(ShapeInterface[] shapes) {
        for (int i = 0; i <= shapes.length - 1; ++i) {
            if (shapes[i] != null) {
                System.out.println("Площадь" + shapes[i].getArea());
            }
        }
    }

    public void sortShapes(ShapeInterface[] shapes) {
        Arrays.sort(shapes, new AreaComparator());
        for (int i = 0; i <= shapes.length - 1; ++i) {
            if (shapes[i] != null) {
                System.out.println("Площадь" + shapes[i].getArea());
            }
        }
    }

    public int[] shapeMaxArea(ShapeInterface[] shapes){
        int max = shapes.length-1;

        int[] array = new int[max+1];
        array[0] = max;

        for (int i = max, j = 1; i > j; --i, ++j) {
            if (shapes[i].getArea() == shapes[i - 1].getArea()){
                 array[j]=i-1;
            } else {
                break;
            }
        }

        return array;
    }

}
