package ru.academits.suvorov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int size) {
        this.vector = new double[size + 1];
    }

    public Vector(Vector v) {
        this.vector = new double[v.vector.length];

        System.arraycopy(v.vector, 0, this.vector, 0, this.vector.length - 1);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("пустой массив");
        }
        this.vector = new double[array.length + 1];

        System.arraycopy(array, 0, vector, 0, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("неккоректно указана размерность массива");
        }
        this.vector = new double[size + 1];

        System.arraycopy(array, 0, this.vector, 0, Math.min(this.vector.length, array.length));
    }

    private double[] getVector() {
        return vector;
    }

    private void setVector(double[] vector) {
        this.vector = vector;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();

        for (int i = 0; i < vector.length - 1; ++i) {
            sB.append(vector[i]).append(", ");
        }
        sB.delete(sB.length() - 2, sB.length() - 1);

        return "{ " + sB + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector vector1 = (Vector) o;

        return vector == vector1.vector;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(vector);

        return hash;
    }

    //Размерность вектора
    public int getSize() {
        return vector.length - 1;
    }

    //Сложение векторов
    public static Vector addition(Vector v1, Vector v2) {
        int size = Math.max(v1.getSize(), v2.getSize());

        Vector result = new Vector(size);

        if (v1.getSize() >= 0) {
            System.arraycopy(v1.vector, 0, result.vector, 0, v1.getSize());
        }
        for (int i = 0; i < v2.getSize(); ++i) {
            result.vector[i] += v2.vector[i];
        }

        return result;
    }

    //Разность векторов
    public static Vector subtraction(Vector v1, Vector v2) {
        int size = Math.max(v1.getSize(), v2.getSize());

        Vector result = new Vector(size);

        if (v1.getSize() >= 0) {
            System.arraycopy(v1.vector, 0, result.vector, 0, v1.getSize());
        }
        for (int i = 0; i < v2.getSize(); ++i) {
            result.vector[i] -= v2.vector[i];
        }

        return result;
    }

    //Скалярное произведение векторов
    public static double scalarProduct(Vector v1, Vector v2) {
        int size = Math.min(v1.getSize(), v2.getSize());
        double scalarProduct = 0;

        for (int i = 0; i < size; ++i) {
            scalarProduct += v1.vector[i] * v2.vector[i];
        }

        return scalarProduct;
    }

    //Сложение векторов (не статик)
    public void getAddition(Vector v) {
        double[] tmp = vector;

        int size = Math.max(this.vector.length, v.vector.length);

        vector = new double[size];

        if (tmp.length - 1 >= 0) {
            System.arraycopy(tmp, 0, this.vector, 0, tmp.length - 1);
        }
        for (int i = 0; i < v.vector.length - 1; ++i) {
            this.vector[i] += v.vector[i];
        }
    }

    //Вычитание векторов (не статик)
    public void getSubtraction(Vector v) {
        double[] tmp = vector;

        int size = Math.max(this.vector.length, v.vector.length);

        vector = new double[size];

        if (tmp.length - 1 >= 0) {
            System.arraycopy(tmp, 0, this.vector, 0, tmp.length - 1);
        }
        for (int i = 0; i < v.vector.length - 1; ++i) {
            this.vector[i] -= v.vector[i];
        }
    }

    //Умножение вектора на скаляр (не статик)
    public void getScalarMultiplication(double scalar) {
        for (int i = 0; i < this.vector.length - 1; ++i) {
            this.vector[i] = this.vector[i] * scalar;
        }
    }

    //Разворот вектора  (не статик)
    public void getVectorReversal() {
        for (int i = 0; i < this.vector.length - 1; ++i) {
            this.vector[i] = this.vector[i] * -1;
        }
    }

    //Длина вектора
    public double getVectorLongitude() {
        double vectorLongitude = 0;

        for (int i = 0; i < vector.length - 1; ++i) {
            vectorLongitude += Math.pow(vector[i], 2);
        }

        return Math.sqrt(vectorLongitude);
    }

    //Получение компоненты вектора по индексу
    public double getValue(int index) {
        if (index >= this.vector.length - 1 || index < 0) {
            throw new IllegalArgumentException("такого индекса нет в массиве");
        }

        return this.vector[index];
    }

    //Установка компоненты вектора по индексу
    public void setValue(int index, double value) {
        if (index >= this.vector.length - 1 || index < 0) {
            throw new IllegalArgumentException("такого индекса нет в массиве");
        }

        this.vector[index] = value;
    }
}