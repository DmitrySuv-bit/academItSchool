package ru.academits.suvorov.main;

import ru.academits.suvorov.range.Range;

import java.util.Arrays;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range[] ranges = new Range[]{new Range(0, 0), new Range(0, 0), new Range(0, 0)};

        System.out.println("Введите число: ");
        double number = scanner.nextDouble();
        System.out.println();

        ranges[0].setFrom(2);
        System.out.println("Начало диапазона 1: " + ranges[0].getFrom());

        ranges[0].setTo(10);
        System.out.println("Конец диапазона 1: " + ranges[0].getTo());
        System.out.println();

        ranges[1].setFrom(5);
        System.out.println("Начало диапазона 2: " + ranges[1].getFrom());

        ranges[1].setTo(15);
        System.out.println("Конец диапазона 2: " + ranges[1].getTo());
        System.out.println();

        ranges[2].setFrom(7);
        System.out.println("Начало диапазона 3: " + ranges[2].getFrom());

        ranges[2].setTo(10);
        System.out.println("Конец диапазона 3: " + ranges[2].getTo());
        System.out.println();

        for (int i = 0; i < ranges.length; ++i) {
            double length = ranges[i].getLength();
            System.out.println("Длина диапазона " + (i + 1) + ": " + length);

            if (ranges[i].isInside(number)) {
                System.out.println("Число " + number + " принадлежит диапазону " + (i + 1) + ":)");
            } else {
                System.out.println("Число " + number + " не принадлежит диапазону " + (i + 1) + ":(");
            }
            System.out.println();
        }

        for (int i = 0; i < ranges.length - 1; ++i) {
            System.out.println("Исходные диапазоны: " + ranges[i] + "\t" + ranges[i + 1]);
            System.out.println("Пересечение диапазонов: " + ranges[i].getIntersection(ranges[i + 1]));
            System.out.println("Сложение диапазонов: " + Arrays.toString(ranges[i].getUnion(ranges[i + 1])));
            System.out.println("Разность диапазонов: " + Arrays.toString(ranges[i].getDifference(ranges[i + 1])));
            System.out.println();
        }
    }
}