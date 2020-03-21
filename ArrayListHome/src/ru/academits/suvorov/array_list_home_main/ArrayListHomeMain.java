package ru.academits.suvorov.array_list_home_main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static void readFile(ArrayList<String> list, Scanner scanner) {
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
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

    public static void main(String[] args) {
        ArrayList<String> stringsList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("./ArrayListHome/strings.txt"))) {
            readFile(stringsList, scanner);

            System.out.println("Чтение из файла и запись в Array List: " + stringsList);
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e);
            System.out.println();
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9));

        System.out.println("Удаление из списка повторяющихся чисел: " + repetitionRemoval(numbersList));
        System.out.println();

        evenNumbersRemove(numbersList);
        System.out.println("Удаление из списка четных чисел: " + numbersList);
    }
}