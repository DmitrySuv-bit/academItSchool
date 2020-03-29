package ru.academits.suvorov.array_list_home_main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static ArrayList<String> getStringsList(String fileAddress) {
        ArrayList<String> stringsList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(fileAddress))) {
            while (scanner.hasNextLine()) {
                stringsList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Не удается найти указанный файл: " + fileAddress);
            System.out.println();
        }

        return stringsList;
    }

    public static void removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    public static ArrayList<Integer> getListWithoutRepetition(ArrayList<Integer> integerList) {
        ArrayList<Integer> integerListWithoutRepetitions = new ArrayList<>();

        for (Integer e : integerList) {
            if (!integerListWithoutRepetitions.contains(e)) {
                integerListWithoutRepetitions.add(e);
            }
        }

        return integerListWithoutRepetitions;
    }

    public static void main(String[] args) {
        ArrayList<String> stringsList = getStringsList("./ArrayListHome/strings.txt");

        System.out.println("Чтение из файла и запись в Array List: " + stringsList);
        System.out.println();

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9));

        System.out.println("Удаление из списка повторяющихся чисел: " + getListWithoutRepetition(numbersList));
        System.out.println();

        removeEvenNumbers(numbersList);
        System.out.println("Удаление из списка четных чисел: " + numbersList);
    }
}