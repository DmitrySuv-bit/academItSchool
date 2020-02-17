package ru.academits.suvorov.vector_main;

import ru.academits.suvorov.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector = new Vector(10);
        System.out.println(vector);

        Vector vector1 = new Vector(vector);
        System.out.println(vector1);

        double[] array = new double[]{4, 5, 6, 7, 8};
        Vector vector2 = new Vector(array);
        System.out.println(vector2);

        double[] array1 = new double[]{2, 2, 3, 3, 3};
        Vector vector3 = new Vector(6, array1);
        System.out.println(vector3);
    }
}
