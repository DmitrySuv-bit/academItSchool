package ru.academits.suvorov.temperature.model;

public class ReaumurConvert implements TemperatureScale {
    @Override
    public String toString() {
        return "Reaumur";
    }

    @Override
    public double convertFromCelsius(double initialTemperature) {
        return initialTemperature / 1.25;
    }

    @Override
    public double convertToCelsius(double initialTemperature) {
        return initialTemperature * 1.25;
    }
}