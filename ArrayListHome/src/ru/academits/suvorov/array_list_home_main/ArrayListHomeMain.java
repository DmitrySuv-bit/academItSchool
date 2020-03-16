package ru.academits.suvorov.array_list_home_main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static void readFile(ArrayList<Integer> list, Scanner scanner) {
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
    }

    public static void evenNumbersRemove(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    public static ArrayList<Integer> repetitionRemoval(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();

        for (Integer e : list) {
            if (!newList.contains(e)) {
                newList.add(e);
            }
        }

        return newList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("./ArrayListHome/numbers.txt"))) {
            readFile(list, scanner);
        }

        System.out.println("Чтение из файла и запись в Array List: " + list);
        System.out.println();

        evenNumbersRemove(list);
        System.out.println("Удаление из списка четных чисел: " + list);
        System.out.println();

        System.out.println("Удаление из списка повторяющихся чисел: " + repetitionRemoval(list));
    }
}