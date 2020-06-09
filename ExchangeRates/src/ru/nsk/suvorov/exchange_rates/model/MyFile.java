package ru.nsk.suvorov.exchange_rates.model;

import com.google.gson.Gson;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MyFile {
    Map<String, Double> map = new HashMap<>();

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


    private void addLineArray(BufferedReader reader) throws IOException {
        String line = reader.readLine();

        while (line != null) {
            if (line.isEmpty()) {
                line = reader.readLine();

                continue;
            }

            String[] linesArray = line.split(";");

            map.put(linesArray[0], Double.parseDouble(linesArray[1]));

            line = reader.readLine();
        }
    }

    public void readJson(String nameFile) throws MalformedURLException {
        URL url = new URL(nameFile);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            Gson gson = new Gson();

            Model model = gson.fromJson(reader, Model.class);

            map.putAll(model.getRates());

        } catch (IOException e) {
            System.out.println("Не удается найти указанный файл: " + nameFile);
        }
    }

    public Map<String, Double> getMap() {
        return map;
    }
}