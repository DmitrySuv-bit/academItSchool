package ru.academits.suvorov.range_main;

import ru.academits.suvorov.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range[] ranges = new Range[]{new Range(2, 10), new Range(2, 4), new Range(7, 10)};

        System.out.println("Введите число: ");
        double number = scanner.nextDouble();
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
            System.out.println("Объединение диапазонов: " + Arrays.toString(ranges[i].getUnion(ranges[i + 1])));
            System.out.println("Разность диапазонов: " + Arrays.toString(ranges[i].getDifference(ranges[i + 1])));
            System.out.println();
        }
    }
}