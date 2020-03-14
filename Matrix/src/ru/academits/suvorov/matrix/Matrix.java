package ru.academits.suvorov.matrix;

import ru.academits.suvorov.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectorsArray;

    public Matrix(int n, int m) {
        this.vectorsArray = new Vector[n];

        for (int i = 0; i < n; ++i) {
            this.vectorsArray[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        this.vectorsArray = new Vector[matrix.vectorsArray.length];

        for (int i = 0; i < vectorsArray.length; ++i){
            this.vectorsArray[i] = new Vector(matrix.vectorsArray[i]);
        }
    }

    public Matrix(double[][] array) {
        int max = 0;

        for (double[] e : array) {
            max = Math.max(max, e.length);
        }

        this.vectorsArray = new Vector[array.length];

        for (int i = 0; i < array.length; ++i) {
            this.vectorsArray[i] = new Vector(max, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        int max = 0;

        for (Vector v : vectors) {
            max = Math.max(max, v.getSize());
        }

        this.vectorsArray = new Vector[vectors.length];

        for (int i = 0; i < vectors.length; ++i){
            this.vectorsArray[i] = new Vector(max);

            for (int j = 0; j < vectors[i].getSize(); ++j){
                this.vectorsArray[i].setValue(j, vectors[i].getValue(j));
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

        return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1).append('}').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(vectorsArray, matrix.vectorsArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vectorsArray);
    }

    public int getLinesCount() {
        return this.vectorsArray.length;
    }

    public int getColumnsCount() {
        return this.vectorsArray[0].getSize();
    }

   public Vector getRows(int index) {
        return new Vector(vectorsArray[index]);
   }

   public void setRows(int index, Vector vector){
       vectorsArray[index] = new Vector(vector);
   }

   public Vector getColumn(int index) {
        Vector columnVector = new Vector(getLinesCount());

        for (int i = 0; i < getLinesCount(); ++i){
            columnVector.setValue(i, vectorsArray[i].getValue(index));
        }

        return columnVector;
   }

   public void setColumn(int index, Vector vector) {
       for (int i = 0; i < getLinesCount(); ++i){
           vectorsArray[i].setValue(index, vector.getValue(i));
       }
   }



}
