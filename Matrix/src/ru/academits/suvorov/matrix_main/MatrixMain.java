package ru.academits.suvorov.matrix_main;

import ru.academits.suvorov.matrix.Matrix;
import ru.academits.suvorov.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        // Матрица нулей размера nxm
        System.out.println("Матрица нулей размера nxm: ");
        Matrix matrix = new Matrix(3, 4);
        System.out.println(matrix);
        System.out.println();

        // Конструктор копирования
        Matrix matrix1 = new Matrix(matrix);

        System.out.println("Конструктор копирования: ");
        System.out.println(matrix1);
        System.out.println();

        // Конструктор из двумерного массива
        double[][] array = {{1, 2}, {4, 5, 6}, {7, 8}};

        Matrix matrix2 = new Matrix(array);

        System.out.println("Конструктор из двумерного массива: ");
        System.out.println(matrix2);
        System.out.println();

        // Конструктор из массива векторов-строк
        double[] array1 = new double[]{1, 2, 3, 4, 5};
        double[] array2 = new double[]{5, 4, 3, 2, 1};
        double[] array3 = new double[]{1, 0, 1, 0, 1};

        Vector[] vectors = {new Vector(7, array1), new Vector(6, array2), new Vector(6, array3)};

        Matrix matrix3 = new Matrix(vectors);

        System.out.println("Конструктор из массива векторов-строк: ");
        System.out.println(matrix3);
        System.out.println();

        // Размерность матрицы
        System.out.println("Размерность матрицы: " + matrix3.getLinesCount() + " X " + matrix3.getColumnsCount());
        System.out.println();

        // Получение вектора-строки по индексу
        System.out.println("Получение вектора-строки по индексу: " + matrix3.getRows(2));
        System.out.println();

        // Задание вектора-строки по индексу
        Matrix matrix4 = new Matrix(matrix3);

        matrix4.setRows(2, new Vector(array1));

        System.out.println("Задание вектора-строки по индексу: " + matrix4);
        System.out.println();

        // Получение вектора-столбца по индексу
        System.out.println("Получение вектора-столбца по индексу: " + matrix3.getColumn(0));
        System.out.println();

        // Задание вектора-столбца по индексу
        Matrix matrix6 = new Matrix(matrix3);

        double[] array4 = new double[]{0, 0, 0};

        matrix6.setColumn(0, new Vector(array4));
        System.out.println("Задание вектора-столбца по индексу: " + matrix6);
        System.out.println();

        System.out.println(matrix3);





        /*// транспонирование матрицы
        Matrix matrix4 = new Matrix(matrix3);

        matrix4.executeTranspose(matrix4);
        System.out.println(matrix4);*/
    }
}
