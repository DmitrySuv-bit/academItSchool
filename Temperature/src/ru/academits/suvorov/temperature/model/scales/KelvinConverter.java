package ru.academits.suvorov.temperature.model.scales;

import ru.academits.suvorov.temperature.model.TemperatureScale;

public class KelvinConverter implements TemperatureScale {
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