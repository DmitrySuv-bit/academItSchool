package ru.academits.suvorov.temperature.model;

public interface TemperatureScale {
    double convertFromCelsius(double initialTemperature);

    double convertToCelsius(double initialTemperature);
}