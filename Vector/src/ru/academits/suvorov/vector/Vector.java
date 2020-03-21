package ru.academits.suvorov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Переданное значение size = " + size + " некорректно. " +
                    "Размерность вектора должна быть > 0");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Размерность переданного массива некорректна, она должна быть > 0");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("Переданное значение size = " + size + " некорректно. " +
                    "Размерность вектора должна быть > 0");
        }

        components = Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");

        for (double v : components) {
            stringBuilder.append(v).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).append('}');

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

        Vector vector = (Vector) o;

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }

    // Размерность вектора
    public int getSize() {
        return components.length;
    }

    //Сложение векторов
    public static Vector add(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        result.add(vector2);

        return result;
    }

    // Разность векторов
    public static Vector subtract(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        result.subtract(vector2);

        return result;
    }

    // Скалярное произведение векторов
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int size = Math.min(vector1.getSize(), vector2.getSize());
        double scalarProduct = 0;

        for (int i = 0; i < size; ++i) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }

    // Сложение векторов (не статик)
    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; ++i) {
            components[i] += vector.components[i];
        }
    }

    // Вычитание векторов (не статик)
    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; ++i) {
            components[i] -= vector.components[i];
        }
    }

    // Умножение вектора на скаляр (не статик)
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; ++i) {
            components[i] *= scalar;
        }
    }

    // Разворот вектора  (не статик)
    public void reverse() {
        multiplyByScalar(-1);
    }

    // Длина вектора
    public double getLength() {
        double squaresSum = 0;

        for (double v : components) {
            squaresSum += Math.pow(v, 2);
        }

        return Math.sqrt(squaresSum);
    }

    // Получение компоненты вектора по индексу
    public double getComponent(int index) {
        if (index >= components.length || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + components.length);
        }

        return components[index];
    }

    // Установка компоненты вектора по индексу
    public void setComponent(int index, double value) {
        if (index >= components.length || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + components.length);
        }

        components[index] = value;
    }
}