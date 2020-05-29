package ru.academits.suvorov.main_csv;

import ru.academits.suvorov.csv.CSVParser;

import java.io.IOException;

public class MainCSV {
    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                CSVParser.parse(args[0], args[1]);
            } else {
                System.out.println("Для запуска разбора CSV, в качестве параметров укажите путь " +
                        "к исходному и конечному файлу, через пробел.");
            }
        } catch (IOException e) {
            System.out.println("Не удается найти указанный файл: " + args[0]);
        }
    }
}