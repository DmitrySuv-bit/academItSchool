package ru.academits.suvorov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorArrayComponents;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("неккоректно указана размерность массива");
        }

        this.vectorArrayComponents = new double[size];
    }

    public Vector(Vector vector) {
        this.vectorArrayComponents = Arrays.copyOf(vector.vectorArrayComponents, vector.vectorArrayComponents.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("пустой массив");
        }

        this.vectorArrayComponents = Arrays.copyOf(array, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("неккоректно указана размерность массива");
        }

        this.vectorArrayComponents = Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");

        for (double v : vectorArrayComponents) {
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

        return Arrays.equals(vectorArrayComponents, vector.vectorArrayComponents);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(vectorArrayComponents);

        return hash;
    }

    // Размерность вектора
    public int getSize() {
        return vectorArrayComponents.length;
    }

    //Сложение векторов
    public static Vector calculateAddition(Vector v1, Vector v2) {
        int size = Math.max(v1.getSize(), v2.getSize());

        Vector result = new Vector(size);

        if (v1.getSize() >= 0) {
            System.arraycopy(v1.vectorArrayComponents, 0, result.vectorArrayComponents, 0, v1.getSize());
        }

        result.calculateAddition(v2);

        return result;
    }

    // Разность векторов
    public static Vector calculateSubtraction(Vector v1, Vector v2) {
        int size = Math.max(v1.getSize(), v2.getSize());

        Vector result = new Vector(size);

        if (v1.getSize() >= 0) {
            System.arraycopy(v1.vectorArrayComponents, 0, result.vectorArrayComponents, 0, v1.getSize());
        }

        result.calculateSubtraction(v2);

        return result;
    }

    // Скалярное произведение векторов
    public static double getScalarProduct(Vector v1, Vector v2) {
        int size = Math.min(v1.getSize(), v2.getSize());
        double scalarProduct = 0;

        for (int i = 0; i < size; ++i) {
            scalarProduct += v1.vectorArrayComponents[i] * v2.vectorArrayComponents[i];
        }

        return scalarProduct;
    }

    // Сложение векторов (не статик)
    public void calculateAddition(Vector v) {
        this.vectorArrayComponents = Arrays.copyOf(this.vectorArrayComponents, Math.max(this.vectorArrayComponents.length, v.vectorArrayComponents.length));

        for (int i = 0; i < v.vectorArrayComponents.length; ++i) {
            this.vectorArrayComponents[i] += v.vectorArrayComponents[i];
        }
    }

    // Вычитание векторов (не статик)
    public void calculateSubtraction(Vector v) {
        this.vectorArrayComponents = Arrays.copyOf(this.vectorArrayComponents, Math.max(this.vectorArrayComponents.length, v.vectorArrayComponents.length));

        for (int i = 0; i < v.vectorArrayComponents.length; ++i) {
            this.vectorArrayComponents[i] -= v.vectorArrayComponents[i];
        }
    }

    // Умножение вектора на скаляр (не статик)
    public void calculateScalarMultiplication(double scalar) {
        for (int i = 0; i < this.vectorArrayComponents.length; ++i) {
            this.vectorArrayComponents[i] *= scalar;
        }
    }

    // Разворот вектора  (не статик)
    public void calculateReversal() {
        calculateScalarMultiplication(-1);
    }

    // Длина вектора
    public double getLength() {
        double length = 0;

        for (double v : vectorArrayComponents) {
            length += Math.pow(v, 2);
        }

        return Math.sqrt(length);
    }

    // Получение компоненты вектора по индексу
    public double getValue(int index) {
        if (index > this.vectorArrayComponents.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("такого индекса нет в массиве");
        }

        return this.vectorArrayComponents[index];
    }

    // Установка компоненты вектора по индексу
    public void setValue(int index, double value) {
        if (index > this.vectorArrayComponents.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("такого индекса нет в массиве");
        }

        this.vectorArrayComponents[index] = value;
    }
}