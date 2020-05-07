package ru.academits.suvorov.temperature.model;

public class ConvertCelsius implements Converter {
    @Override
    public String getScale() {
        return "Celsius";
    }

    @Override
    public double convertTemperature(double initialTemperature, String output) {
        if (output.equals("Celsius")) {
            return initialTemperature;
        }
        if (output.equals("Fahrenheit")) {
            return initialTemperature * 9.0 / 5 + 32;
        }
        if (output.equals("Kelvin")) {
            return initialTemperature + 273.15;
        }

        return 0;
    }
}