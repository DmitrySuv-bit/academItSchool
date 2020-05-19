package ru.academits.suvorov.temperature.model;

public class FahrenheitConvert implements TemperatureScale {
    @Override
    public String toString() {
        return "Fahrenheit";
    }

    @Override
    public double convertFromCelsius(double initialTemperature) {
        return initialTemperature * 9.0 / 5.0 + 32.0;
    }

    @Override
    public double convertToCelsius(double initialTemperature) {
        return 5.0 / 9.0 * (initialTemperature - 32);
    }
}