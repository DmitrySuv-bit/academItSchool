package ru.nsk.suvorov.exchange_rates.main;

import ru.nsk.suvorov.exchange_rates.model.MyFile;
import ru.nsk.suvorov.exchange_rates.view.Frame;
import ru.nsk.suvorov.exchange_rates.view.View;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MyFile file = new MyFile();

        file.readJson("https://api.exchangeratesapi.io/latest");
        file.readURlFile("http://assets.cavexp.com/test.txt");
        file.readFile("ExchangeRates/src/input.txt");
        file.readFile("ExchangeRates/src/test1.txt");

        View view = new Frame(file);

        view.startApplication();
    }
}