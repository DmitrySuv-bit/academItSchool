package ru.academits.suvorov.temperature.model;

public class ConvertKelvin implements Converter {
    @Override
    public String getScale() {
        return "Kelvin";
    }

    @Override
    public double convertTemperature(double initialTemperature, String output) {
        if (output.equals("Celsius")) {
            return initialTemperature - 273.15;
        }
        if (output.equals("Fahrenheit")) {
            return (initialTemperature - 273.15) * 9.0 / 5 + 32;
        }
        if (output.equals("Kelvin")) {
            return initialTemperature;
        }

        return 0;
    }
}