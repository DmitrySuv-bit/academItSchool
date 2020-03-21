package ru.academits.suvorov.array_list_home_main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static void readFile(ArrayList<String> list, Scanner scanner) {
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
    }

    public static void removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    public static ArrayList<Integer> removeRepetitionNumbers(ArrayList<Integer> integerList) {
        ArrayList<Integer> integerListWithoutRepetitions = new ArrayList<>();

        for (Integer e : integerList) {
            if (!integerListWithoutRepetitions.contains(e)) {
                integerListWithoutRepetitions.add(e);
            }
        }

        return integerListWithoutRepetitions;
    }

    public static void main(String[] args) {
        ArrayList<String> stringsList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("./ArrayListHome/strings.txt"))) {
            readFile(stringsList, scanner);

            System.out.println("Чтение из файла и запись в Array List: " + stringsList);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
            System.out.println();
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9));

        System.out.println("Удаление из списка повторяющихся чисел: " + removeRepetitionNumbers(numbersList));
        System.out.println();

        removeEvenNumbers(numbersList);
        System.out.println("Удаление из списка четных чисел: " + numbersList);
    }
}