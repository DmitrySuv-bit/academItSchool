package ru.academits.suvorov.matrix;

import ru.academits.suvorov.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rows, int columns) {
        if (rows <= 0) {
            throw new IllegalArgumentException("Переданное количество строк n = " + rows + " некорректно. " +
                    "Колличество строк должно быть > 0");
        }
        if (columns <= 0) {
            throw new IllegalArgumentException("Переданное количество столбцов m = " + columns + " некорректно. " +
                    "Колличество столбцов должно быть > 0");
        }

        this.rows = new Vector[rows];

        for (int i = 0; i < rows; ++i) {
            this.rows[i] = new Vector(columns);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < rows.length; ++i) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Количество строк переданого массива = " + array.length
                    + " некорректно, оно должна быть > 0");
        }

        int maxCountColumns = 0;

        for (double[] e : array) {
            maxCountColumns = Math.max(maxCountColumns, e.length);
        }

        if (maxCountColumns == 0) {
            throw new IllegalArgumentException("Количество столбцов переданого массива = " + maxCountColumns
                    + " некорректно, оно должна быть > 0");
        }

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; ++i) {
            rows[i] = new Vector(maxCountColumns, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Количество векторов-строк в массиве = " + vectors.length
                    + " некорректно, оно должна быть > 0");
        }
        int maxCountElementsInVector = 0;

        for (Vector v : vectors) {
            maxCountElementsInVector = Math.max(maxCountElementsInVector, v.getSize());
        }

        rows = new Vector[vectors.length];

        for (int i = 0; i < vectors.length; ++i) {
            rows[i] = new Vector(maxCountElementsInVector);

            for (int j = 0; j < vectors[i].getSize(); ++j) {
                rows[i].setComponent(j, vectors[i].getComponent(j));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (Vector v : rows) {
            stringBuilder.append(v).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1).append("}");

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

        return Arrays.equals(rows, matrix.rows);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(rows);

        return hash;
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if (index >= getRowsCount() || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + getRowsCount());
        }

        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector vector) {
        if (index >= getRowsCount() || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + getRowsCount());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if (index >= getColumnsCount() || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + getColumnsCount());
        }

        Vector columnVector = new Vector(getRowsCount());

        for (int i = 0; i < getRowsCount(); ++i) {
            columnVector.setComponent(i, rows[i].getComponent(index));
        }

        return columnVector;
    }

    public void transpose() {
        Vector[] transposeMatrix = new Vector[getColumnsCount()];

        for (int i = 0; i < getColumnsCount(); ++i) {
            transposeMatrix[i] = getColumn(i);
        }

        rows = transposeMatrix;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector v : rows) {
            v.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (getRowsCount() != getColumnsCount()) {
            throw new UnsupportedOperationException("Переданная матрица имеет размеры: Rows = " + getRowsCount()
                    + ", Columns = " + getColumnsCount() + ". Для вычисления определителя она должна быть квадратной");
        }
        if (getRowsCount() == 1) {
            return rows[0].getComponent(0);
        }
        if (getRowsCount() == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1)
                    - rows[1].getComponent(0) * rows[0].getComponent(1);
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

                    minorLine.setComponent(k, rows[j].getComponent(step));

                    ++step;
                }
                minor.setRow(j - 1, minorLine);
            }
            determinant += Math.pow(-1, i) * rows[0].getComponent(i) * minor.getDeterminant();
        }

        return determinant;
    }

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Матрица и вектор не согласованы. Количество столбцов в матрице " +
                    "Columns = " + getColumnsCount() + " должно равняться количеству элементов в векторе-строке " +
                    "Size = " + vector.getSize());
        }

        Vector result = new Vector(getRowsCount());

        for (int i = 0; i < getRowsCount(); ++i) {
            double newComponent = 0;

            for (int j = 0; j < getColumnsCount(); ++j) {
                newComponent += rows[i].getComponent(j) * vector.getComponent(j);
            }

            result.setComponent(i, newComponent);
        }

        return result;
    }

    public void add(Matrix matrix) {
        checkMatrixDimension(matrix);

        for (int i = 0; i < getRowsCount(); ++i) {
            for (int j = 0; j < getColumnsCount(); ++j) {
                rows[i].setComponent(j, rows[i].getComponent(j) + matrix.rows[i].getComponent(j));
            }
        }
    }

    public void subtract(Matrix matrix) {
        checkMatrixDimension(matrix);

        for (int i = 0; i < getRowsCount(); ++i) {
            for (int j = 0; j < getColumnsCount(); ++j) {
                rows[i].setComponent(j, rows[i].getComponent(j) - matrix.rows[i].getComponent(j));
            }
        }
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        checkMatrixDimension(matrix1, matrix2);

        Matrix result = new Matrix(matrix1);

        result.add(matrix2);

        return result;
    }

    public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
        checkMatrixDimension(matrix1, matrix2);

        Matrix result = new Matrix(matrix1);

        result.subtract(matrix2);

        return result;
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Матрица и вектор не согласованы. Количество столбцов Columns = " +
                    matrix1.getColumnsCount() + " в matrix1 должно равняться количеству строк Rows = " +
                    matrix2.getRowsCount() + " в matrix2");
        }

        Matrix result = new Matrix(matrix1.getRowsCount(), matrix2.getColumnsCount());

        for (int i = 0; i < matrix1.getRowsCount(); ++i) {
            Vector multiply = new Vector(matrix2.getColumnsCount());

            for (int j = 0; j < matrix2.getColumnsCount(); ++j) {
                multiply.setComponent(j, Vector.getScalarProduct(matrix1.getRow(i), matrix2.getColumn(j)));
            }

            result.setRow(i, multiply);
        }

        return result;
    }

    private void checkMatrixDimension(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() && getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException("Переданные матрицы разной размерности, вычисления невозможны." +
                    " Размерность первой матрицы Rows1 = " + getRowsCount() + ", Columns1 = " + getColumnsCount() +
                    ", размерность второй матрицы Rows2 = " + matrix.getRowsCount() +
                    ", Columns2 = " + matrix.getColumnsCount());
        }
    }

    private static void checkMatrixDimension(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() && matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Переданные матрицы разной размерности, вычисления невозможны." +
                    " Размерность первой матрицы Rows1 = " + matrix1.getRowsCount() + ", Columns1 = " +
                    matrix1.getColumnsCount() + ", размерность второй матрицы Rows2 = " + matrix2.getRowsCount() +
                    ", Columns2 = " + matrix2.getColumnsCount());
        }
    }
}