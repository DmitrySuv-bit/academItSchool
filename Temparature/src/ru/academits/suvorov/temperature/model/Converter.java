package ru.academits.suvorov.temperature.model;

public interface Converter {
    String getScale();

    double convertTemperature(double initialTemperature, String output);
}