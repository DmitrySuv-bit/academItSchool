package ru.academits.suvorov.vector_main;

import ru.academits.suvorov.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        //Vector(n) – размерность n, все компоненты равны 0
        Vector vector0 = new Vector(10);

        System.out.println("Вектор 0: " + vector0);
        System.out.println();

        //Vector(Vector) – конструктор копирования
        Vector vector1 = new Vector(vector0);

        System.out.println("Копия вектора 0: " + vector1);
        System.out.println();

        //Vector(double[]) – заполнение вектора значениями из массива
        double[] array = new double[]{1, 2};

        Vector vector2 = new Vector(array);

        System.out.println("Вектор 2: " + vector2);
        System.out.println();

        //Vector(n, double[]) – заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
        double[] array1 = new double[]{3, 4, 5, 6, 7};

        Vector vector3 = new Vector(8, array1);

        System.out.println("Вектор 3: " + vector3);
        System.out.println();

        //Размерность вектора
        System.out.println("Размерность вектора 2: " + vector2.getSize());
        System.out.println("Размерность вектора 3: " + vector3.getSize());
        System.out.println();

        //Сложение векторов
        System.out.println("Сложение векторов 2 и 3: " + Vector.addition(vector2, vector3));
        System.out.println();

        //Вычитание векторов
        System.out.println("Вычитание 3 векторов из 2: " + Vector.subtraction(vector2, vector3));
        System.out.println();

        //Скалярное произведение векторов
        System.out.println("Скалярное произведение векторов 2 и 3: " + Vector.scalarProduct(vector2, vector3));
        System.out.println();

        //Сложение векторов (не статик)
        Vector vector4 = new Vector(vector2);

        vector4.getAddition(vector3);

        System.out.println("Сложение векторов 2 и 3 (не статик): " + vector4);
        System.out.println();

        //Вычитание векторов (не статик)
        Vector vector5 = new Vector(vector3);

        vector5.getSubtraction(vector2);

        System.out.println("Вычитание 2 векторов из 3 (не статик): " + vector5);
        System.out.println();

        //Умножение вектора на скаляр (не статик)
        Vector vector6 = new Vector(vector2);

        vector6.getScalarMultiplication(5);

        System.out.println("Умножение вектора 2 на скаляр (не статик): " + vector6);
        System.out.println();

        //Разворот вектора (не статик)
        Vector vector7 = new Vector(vector3);

        vector7.getVectorReversal();

        System.out.println("Разворот вектора 3 (не статик): " + vector7);
        System.out.println();

        //Получение длины вектора (не статик)
        System.out.println("Длина вектора 2 (не статик): " + vector2.getVectorLongitude());
        System.out.println("Длина вектора 3 (не статик): " + vector3.getVectorLongitude());
        System.out.println();

        //Получение компоненты вектора по индексу
        System.out.println("Получение компоненты вектора по индексу: " + vector3.getValue(2));
        System.out.println();

        //Установка компоненты вектора по индексу
        Vector vector8 = new Vector(vector2);

        vector8.setValue(0, 5);

        System.out.println("Установка компоненты вектора по индексу: " + vector8);
    }
}