package ru.academits.suvorov.temperature.model;

public class ConvertFahrenheit implements Converter {
    @Override
    public String getScale() {
        return "Fahrenheit";
    }

    @Override
    public double convertTemperature(double initialTemperature, String output) {
        if (output.equals("Celsius")) {
            return 5.0 / 9 * (initialTemperature - 32);
        }
        if (output.equals("Fahrenheit")) {
            return initialTemperature;
        }
        if (output.equals("Kelvin")) {
            return 5.0 / 9 * (initialTemperature - 32) + 273.15;
        }

        return 0;
    }
}