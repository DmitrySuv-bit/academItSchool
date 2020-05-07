package ru.academits.suvorov.temperature.main;

import ru.academits.suvorov.temperature.model.*;
import ru.academits.suvorov.temperature.view.FrameView;
import ru.academits.suvorov.temperature.view.View;

public class TemperatureMain {
    public static void main(String[] args) {
        Converter[] converter = {new ConvertCelsius(), new ConvertFahrenheit(), new ConvertKelvin()};

        View view = new FrameView(converter);

        view.startApplication();
    }
}