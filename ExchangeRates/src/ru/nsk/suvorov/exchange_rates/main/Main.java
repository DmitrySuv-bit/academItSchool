package ru.nsk.suvorov.exchange_rates.main;

import ru.nsk.suvorov.exchange_rates.model.File;
import ru.nsk.suvorov.exchange_rates.view.Frame;
import ru.nsk.suvorov.exchange_rates.view.View;

public class Main {
    public static void main(String[] args) {
        File file = new File();

        file.readFile("ExchangeRates/src/input.txt");
        file.readFile("ExchangeRates/src/test1.txt");

        View view = new Frame(file);

        view.startApplication();
    }
}