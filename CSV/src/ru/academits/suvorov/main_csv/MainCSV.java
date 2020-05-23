package ru.academits.suvorov.main_csv;

import ru.academits.suvorov.csv.CSVParser;

import java.io.IOException;

public class MainCSV {
    public static void main(String[] args) {
        try {
            if (args.length == 1 && args[0].equals("help")) {
                System.out.println("Для запуска разбора CSV, в качестве параметров укажите путь " +
                        "к исходному и конечному файлу, через пробел.");

                return;
            }

            CSVParser.disassemble(args[0], args[1]);
        } catch (IOException e) {
            System.out.println("Не удается найти указанный файл: " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введены не все аргументы, для корректной работы программы.");
        }
    }
}