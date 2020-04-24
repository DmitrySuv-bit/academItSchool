package ru.academits.suvorov.model;

public class TemperatureConverter {
    public static double convertTemperature(double initialTemperature, String input, String output) {
        switch (input) {
            case "Celsius":
                switch (output) {
                    case "Celsius":
                        return initialTemperature;
                    case "Fahrenheit":
                        return initialTemperature * 9.0 / 5 + 32;
                    case "Kelvin":
                        return initialTemperature + 273.15;
                }

            case "Fahrenheit":
                switch (output) {
                    case "Celsius":
                        return 5.0 / 9 * (initialTemperature - 32);
                    case "Fahrenheit":
                        return initialTemperature;
                    case "Kelvin":
                        return 5.0 / 9 * (initialTemperature - 32) + 273.15;
                }

            case "Kelvin":
                switch (output) {
                    case "Celsius":
                        return initialTemperature - 273.15;
                    case "Fahrenheit":
                        return (initialTemperature - 273.15) * 9.0 / 5 + 32;
                    case "Kelvin":
                        return initialTemperature;
                }
        }

        return 0;
    }
}
