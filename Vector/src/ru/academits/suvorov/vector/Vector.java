package ru.academits.suvorov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int size) {
        this.vector = new double[size];
    }

    public Vector(Vector v) {
        this.vector = v.vector;
    }

    public Vector(double[] array) {
        this.vector = array;
    }

    public Vector(int size, double[] array) {
        this.vector = new double[size];

        System.arraycopy(array, 0, this.vector, 0, Math.min(this.vector.length, array.length));
    }

    public double[] getVector() {
        return vector;
    }

    @Override
    public String toString() {
        return "Vector{" + Arrays.toString(vector) + '}';
    }


}