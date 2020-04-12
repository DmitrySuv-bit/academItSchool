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
        double[] array1 = new double[]{4, 2, 3};
        double[] array2 = new double[]{2, 8, 7};
        double[] array3 = new double[]{9, 3, 5};

        Vector[] vectors = {new Vector(3, array1), new Vector(3, array2), new Vector(3, array3)};

        Matrix matrix3 = new Matrix(vectors);

        System.out.println("Конструктор из массива векторов-строк: ");
        System.out.println(matrix3);
        System.out.println();

        // Размерность матрицы
        System.out.println("Размерность матрицы: " + matrix3.getRowsCount() + " X " + matrix3.getColumnsCount());
        System.out.println();

        // Получение вектора-строки по индексу
        System.out.println("Получение вектора-строки по индексу: " + matrix3.getRow(2));
        System.out.println();

        // Задание вектора-строки по индексу
        Matrix matrix4 = new Matrix(matrix3);

        matrix4.setRow(2, new Vector(array1));

        System.out.println("Задание вектора-строки по индексу: " + matrix4);
        System.out.println();

        // Получение вектора-столбца по индексу
        System.out.println("Получение вектора-столбца по индексу: " + matrix3.getColumn(0));
        System.out.println();

        // Транспонирование матрицы
        Matrix matrix6 = new Matrix(matrix3);

        matrix6.transpose();

        System.out.println("Транспонирование матрицы: " + matrix6);
        System.out.println();

        // Умножение на скаляр
        Matrix matrix7 = new Matrix(matrix3);

        matrix7.multiplyByScalar(5);

        System.out.println("Умножение на скаляр: " + matrix7);
        System.out.println();

        // Вычисление определителя матрицы
        System.out.println("Определитель матрицы: " + matrix3.getDeterminant());
        System.out.println();

        // Умножение матрицы на вектор
        System.out.println("Умножение матрицы на вектор: " + matrix3.multiplyByVector(new Vector(3, array1)));
        System.out.println();

        // Сложение матриц
        Matrix matrix8 = new Matrix(matrix6);

        matrix8.add(matrix7);

        System.out.println("Сложение матриц: " + matrix8);
        System.out.println();

        // Разность матриц
        Matrix matrix9 = new Matrix(matrix6);

        matrix9.subtract(matrix7);

        System.out.println("Разность матриц: " + matrix9);
        System.out.println();

        // Сложение матриц static
        System.out.println("Сложение матриц static: " + Matrix.add(matrix6, matrix7));
        System.out.println();

        // Разность матриц static
        System.out.println("Разность матриц static: " + Matrix.subtract(matrix6, matrix7));
        System.out.println();

        // Умножение матриц static
        System.out.println("Умножение матриц static: " + Matrix.multiply(matrix6, matrix7));
        System.out.println();
    }
}