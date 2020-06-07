package ru.nsk.suvorov.exchange_rates.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File {
    ArrayList<String[]> list = new ArrayList<>();

    public void readFile(String nameFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
            String line = reader.readLine();

            while (line != null) {
                if (line.isEmpty()) {
                    line = reader.readLine();

                    continue;
                }

                list.add(line.split(";"));

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Не удается найти указанный файл: " + nameFile);
        }
    }

    public ArrayList<String[]> getList() {
        return list;
    }
}