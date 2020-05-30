package ru.academits.suvorov.temperature.model;

public class ConvertTemperature {
    public static double convert(double temperature, TemperatureScale inputScale, TemperatureScale outputScale) {
        if (!inputScale.equals(outputScale)) {
            double result = inputScale.convertToCelsius(temperature);

            return outputScale.convertFromCelsius(result);
        }

        return temperature;
    }
}