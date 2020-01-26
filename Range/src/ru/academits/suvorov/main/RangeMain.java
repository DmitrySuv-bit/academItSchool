package ru.academits.suvorov.main;

import ru.academits.suvorov.range.Range;

import java.util.Arrays;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range1 = new Range(0, 0);
        Range range2 = new Range(0, 0);

        System.out.println("Введите число: ");
        double number = scanner.nextDouble();
        System.out.println();

        range1.setFrom(2);
        System.out.println("Начало диапазона 1: " + range1.getFrom());

        range1.setTo(10);
        System.out.println("Конец диапазона 1: " + range1.getTo());

        double length = range1.getLength();
        System.out.println("Длина диапазона 1: " + length);

        if (range1.isInside(number)) {
            System.out.println("Число " + number + " принадлежит диапазону 1:)");
        } else {
            System.out.println("Число " + number + " не принадлежит диапазону 1:(");
        }
        System.out.println();

        range2.setFrom(10);
        System.out.println("Начало диапазона 2: " + range2.getFrom());

        range2.setTo(15);
        System.out.println("Конец диапазона 2: " + range2.getTo());

        double length2 = range2.getLength();
        System.out.println("Длина диапазона 2: " + length2);

        if (range2.isInside(number)) {
            System.out.println("Число " + number + " принадлежит диапазону 2:)");
        } else {
            System.out.println("Число " + number + " не принадлежит диапазону 2:(");
        }
        System.out.println();

        System.out.println("Пересечение диапазонов: ");
        System.out.println(range1.getIntersection(range2));
        System.out.println();

        System.out.println("Сложение диапазонов: ");
        System.out.println(range1.getUnion(range2));
        System.out.println();

        System.out.println("Разность диапазонов: ");
        System.out.println(Arrays.toString(range1.getDifference(range2)));
    }
}