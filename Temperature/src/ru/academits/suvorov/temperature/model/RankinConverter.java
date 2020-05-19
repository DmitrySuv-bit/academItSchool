package ru.academits.suvorov.temperature.model;

public class RankinConverter implements TemperatureScale {
    @Override
    public String toString() {
        return "Rankin";
    }

    @Override
    public double convertFromCelsius(double initialTemperature) {
        return initialTemperature * 9.0 / 5.0 + 491.67;
    }

    @Override
    public double convertToCelsius(double initialTemperature) {
        return 5.0 / 9.0 * (initialTemperature - 491.67);
    }
}