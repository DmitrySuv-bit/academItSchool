package ru.academits.suvorov.temperature.model;

public class KelvinConvert implements TemperatureScale {
    @Override
    public String toString() {
        return "Kelvin";
    }

    @Override
    public double convertFromCelsius(double initialTemperature) {
        return initialTemperature + 273.15;
    }

    @Override
    public double convertToCelsius(double initialTemperature) {
        return initialTemperature - 273.15;
    }
}