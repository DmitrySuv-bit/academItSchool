package ru.academits.suvorov.matrix;

import ru.academits.suvorov.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectorsArray;

    public Matrix(int n, int m) {
        if (n <= 0) {
            throw new IllegalArgumentException("Переданное количество строк n = " + n + " некорректно. " +
                    "Колличество строк должно быть > 0");
        }
        if (m <= 0) {
            throw new IllegalArgumentException("Переданное количество столбцов m = " + m + " некорректно. " +
                    "Колличество столбцов должно быть > 0");
        }

        this.vectorsArray = new Vector[n];

        for (int i = 0; i < n; ++i) {
            this.vectorsArray[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        this.vectorsArray = new Vector[matrix.vectorsArray.length];

        for (int i = 0; i < vectorsArray.length; ++i) {
            this.vectorsArray[i] = new Vector(matrix.vectorsArray[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Количество строк переданого массива = " + array.length + " некорректно, она должна быть > 0");
        }

        int max = 0;

        for (double[] e : array) {
            max = Math.max(max, e.length);
        }

        if (max <= 0) {
            throw new IllegalArgumentException("Количество столбцов переданого массива = " + max + " некорректно, она должна быть > 0");
        }

        this.vectorsArray = new Vector[array.length];

        for (int i = 0; i < array.length; ++i) {
            this.vectorsArray[i] = new Vector(max, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length <= 0) {
            throw new IllegalArgumentException("Количество векторов-строк в массиве = " + vectors.length + " некорректно, она должна быть > 0");
        }
        int max = 0;

        for (Vector v : vectors) {
            max = Math.max(max, v.getSize());
        }

        if (max <= 0) {
            throw new IllegalArgumentException("Максимальное количество элементов в векторе-строк = " + max + " некорректно, она должна быть > 0");
        }

        this.vectorsArray = new Vector[vectors.length];

        for (int i = 0; i < vectors.length; ++i) {
            this.vectorsArray[i] = new Vector(max);

            for (int j = 0; j < vectors[i].getSize(); ++j) {
                this.vectorsArray[i].setComponent(j, vectors[i].getComponent(j));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");

        for (Vector v : vectorsArray) {
            stringBuilder.append(v).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1).append('}');

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Matrix matrix = (Matrix) o;

        return Arrays.equals(vectorsArray, matrix.vectorsArray);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(vectorsArray);

        return hash;
    }

    public int getRowsCount() {
        return this.vectorsArray.length;
    }

    public int getColumnsCount() {
        return this.vectorsArray[0].getSize();
    }

    public Vector getRow(int index) {
        if (index >= getRowsCount() || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + getRowsCount());
        }

        return new Vector(vectorsArray[index]);
    }

    public void setRow(int index, Vector vector) {
        if (index >= getRowsCount() || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + getRowsCount());
        }

        vectorsArray[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if (index >= getColumnsCount() || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + getColumnsCount());
        }

        Vector columnVector = new Vector(getRowsCount());

        for (int i = 0; i < getRowsCount(); ++i) {
            columnVector.setComponent(i, vectorsArray[i].getComponent(index));
        }

        return columnVector;
    }

    public void transpose() {
        Vector[] tmp = new Vector[getColumnsCount()];

        for (int i = 0; i < getColumnsCount(); ++i) {
            tmp[i] = getColumn(i);
        }

        vectorsArray = tmp;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector v : vectorsArray) {
            v.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (getRowsCount() != getColumnsCount()) {
            throw new IllegalArgumentException("Переданая матрица не квадратная, вычисление определителя невозможно");
        }
        if (getRowsCount() == 1) {
            return vectorsArray[0].getComponent(0);
        }
        if (getRowsCount() == 2) {
            return vectorsArray[0].getComponent(0) * vectorsArray[1].getComponent(1) - vectorsArray[1].getComponent(0) * vectorsArray[0].getComponent(1);
        }

        double determinant = 0;

        for (int i = 0; i < getRowsCount(); ++i) {
            Matrix minor = new Matrix(getRowsCount() - 1, getRowsCount() - 1);

            for (int j = 1; j < getRowsCount(); ++j) {
                Vector minorLine = new Vector(getRowsCount() - 1);

                int step = 0;

                for (int k = 0; k < getRowsCount() - 1; ++k) {
                    if (step == i) {
                        ++step;
                    }

                    minorLine.setComponent(k, vectorsArray[j].getComponent(step));

                    ++step;
                }
                minor.setRow(j - 1, minorLine);
            }
            determinant += Math.pow(-1, i) * vectorsArray[0].getComponent(i) * minor.getDeterminant();
        }

        return determinant;
    }

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Матрица и вектор не согласованы. Количество столбцов в матрице " +
                    "должно равняться количеству элементов в в векторе-строке");
        }

        Vector result = new Vector(getRowsCount());

        for (int i = 0; i < getRowsCount(); ++i) {
            double sum = 0;

            for (int j = 0; j < getColumnsCount(); ++j) {
                sum += vectorsArray[i].getComponent(j) * vector.getComponent(j);
            }

            result.setComponent(i, sum);
        }

        return result;
    }

    public void add(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() && getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException("Переданные матрицы разной размерности, сложение матриц невозможно");
        }
        for (int i = 0; i < getRowsCount(); ++i) {
            vectorsArray[i].add(matrix.getRow(i));
        }
    }

    public void subtract(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() && getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException("Переданные матрицы разной размерности, вычитание матриц невозможно");
        }
        for (int i = 0; i < getRowsCount(); ++i) {
            vectorsArray[i].subtract(matrix.getRow(i));
        }
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1);

        result.add(matrix2);

        return result;
    }

    public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1);

        result.subtract(matrix2);

        return result;
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Матрица и вектор не согласованы. Количество столбцов в матрице А " +
                    "должно равняться количеству строк в матрице В");
        }

        Matrix result = new Matrix(matrix1.getRowsCount(), matrix2.getColumnsCount());

        for (int i = 0; i < result.getRowsCount(); ++i) {
            Vector multiply = new Vector(matrix1.getColumnsCount());

            for (int j = 0; j < result.getColumnsCount(); ++j) {
                multiply.setComponent(j, Vector.getScalarProduct(matrix1.getRow(i), matrix2.getColumn(j)));
            }

            result.setRow(i, multiply);
        }

        return result;
    }
}