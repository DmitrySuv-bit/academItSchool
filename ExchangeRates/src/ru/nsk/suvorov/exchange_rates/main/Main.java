package ru.nsk.suvorov.exchange_rates.main;

import ru.nsk.suvorov.exchange_rates.model.File;
import ru.nsk.suvorov.exchange_rates.view.Frame;
import ru.nsk.suvorov.exchange_rates.view.View;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        File file = new File();

        file.readURlFile("http://assets.cavexp.com/test.txt");
        file.readFile("ExchangeRates/src/input.txt");
        file.readFile("ExchangeRates/src/test1.txt");

        View view = new Frame(file);

        view.startApplication();
    }
}