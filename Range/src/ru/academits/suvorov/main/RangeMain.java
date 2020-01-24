package ru.academits.suvorov.main;

import ru.academits.suvorov.range.Range;

import java.util.Arrays;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range = new Range(0, 0);

        System.out.println("Введите число: ");
        double number = scanner.nextDouble();
        System.out.println();

        range.setFrom(3);
        System.out.println("Начало диапазона 1: " + range.getFrom());

        range.setTo(11);
        System.out.println("Конец диапазона 1: " + range.getTo());

        double length1 = range.getLength1();
        System.out.println("Длина диапазона 1: " + length1);

        if (range.isInside1(number)) {
            System.out.println("Число " + number + " принадлежит диапазону 1:)");
        } else {
            System.out.println("Число " + number + " не принадлежит диапазону 1:(");
        }
        System.out.println();

        double from = 3;
        System.out.println("Начало диапазона 2: " + from);

        double to = 5;
        System.out.println("Конец диапазона 2: " + to);

        double length2 = range.getLength2(from, to);
        System.out.println("Длина диапазона 2: " + length2);

        if (range.isInside2(number, from, to)) {
            System.out.println("Число " + number + " принадлежит диапазону 2:)");
        } else {
            System.out.println("Число " + number + " не принадлежит диапазону 2:(");
        }
        System.out.println();

        System.out.println("Пересечение диапазонов: ");
        System.out.println(Arrays.toString(range.intervalsIntersection(from, to)));
        System.out.println();

        System.out.println("Сложение диапазонов: ");
        System.out.println(Arrays.toString(range.intervalsAddition(from, to)));
        System.out.println();

        System.out.println("Разность диапазонов: ");
        System.out.println(Arrays.toString(range.intervalsDifference(from, to)));
    }
}