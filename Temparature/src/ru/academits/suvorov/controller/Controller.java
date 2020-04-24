package ru.academits.suvorov.controller;

import ru.academits.suvorov.view.View;

public class Controller  {
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void convertTemperature() {
        view.startApplication();
    }
}