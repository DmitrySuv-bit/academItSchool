package ru.nsk.suvorov.exchange_rates.model;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class File {
    ArrayList<String[]> list = new ArrayList<>();

    public void readURlFile(String nameFile) throws MalformedURLException {
        URL url = new URL(nameFile);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            addLineArray(reader);
        } catch (IOException e) {
            System.out.println("Не удается найти указанный файл: " + nameFile);
        }
    }

    public void readFile(String nameFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
            addLineArray(reader);
        } catch (IOException e) {
            System.out.println("Не удается найти указанный файл: " + nameFile);
        }
    }


    private void addLineArray (BufferedReader reader) throws IOException {
        String line = reader.readLine();

        while (line != null) {
            if (line.isEmpty()) {
                line = reader.readLine();

                continue;
            }

            list.add(line.split(";"));

            line = reader.readLine();
        }
    }

    public ArrayList<String[]> getList() {
        return list;
    }
}