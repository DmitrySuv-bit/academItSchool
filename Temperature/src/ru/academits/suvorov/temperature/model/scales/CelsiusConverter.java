package ru.academits.suvorov.temperature.model.scales;

import ru.academits.suvorov.temperature.model.TemperatureScale;

public class CelsiusConverter implements TemperatureScale {
    @Override
    public String toString() {
        return "Celsius";
    }

    @Override
    public double convertFromCelsius(double initialTemperature) {
        return initialTemperature;
    }

    @Override
    public double convertToCelsius(double initialTemperature) {
        return initialTemperature;
    }
}