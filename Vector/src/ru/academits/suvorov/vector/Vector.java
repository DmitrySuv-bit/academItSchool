package ru.academits.suvorov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Переданое значение size = " + size + " неккоректно. " +
                    "Размерность массива должна быть > 0");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("пустой массив");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("Переданое значение size = " + size + " неккоректно. " +
                    "Размерность массива должна быть > 0");
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
    public static Vector addition(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        result.addition(vector2);

        return result;
    }

    // Разность векторов
    public static Vector subtraction(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        result.subtraction(vector2);

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
    public void addition(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, Math.max(components.length, vector.components.length));
        }

        int minLength = Math.min(components.length, vector.components.length);

        for (int i = 0; i < minLength; ++i) {
            components[i] += vector.components[i];
        }
    }

    // Вычитание векторов (не статик)
    public void subtraction(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, Math.max(components.length, vector.components.length));
        }

        int minLength = Math.min(components.length, vector.components.length);

        for (int i = 0; i < minLength; ++i) {
            components[i] -= vector.components[i];
        }
    }

    // Умножение вектора на скаляр (не статик)
    public void multiplyVectorByScalar(double scalar) {
        for (int i = 0; i < components.length; ++i) {
            components[i] *= scalar;
        }
    }

    // Разворот вектора  (не статик)
    public void reversal() {
        multiplyVectorByScalar(-1);
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
    public double getValue(int index) {
        if (index >= components.length || index < 0) {
            throw new IndexOutOfBoundsException("Переданое значение index = " + index + " неккоректно." +
                    " Значение должно выполнять условие 0 <= index < " + components.length);
        }

        return components[index];
    }

    // Установка компоненты вектора по индексу
    public void setValue(int index, double value) {
        if (index >= components.length || index < 0) {
            throw new IndexOutOfBoundsException("Переданое значение index = " + index + " неккоректно." +
                    " Значение должно выполнять условие 0 <= index < " + components.length);
        }

        components[index] = value;
    }
}