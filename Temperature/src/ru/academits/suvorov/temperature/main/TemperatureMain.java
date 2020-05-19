package ru.academits.suvorov.temperature.main;

import ru.academits.suvorov.temperature.model.*;
import ru.academits.suvorov.temperature.view.FrameView;
import ru.academits.suvorov.temperature.view.View;

public class TemperatureMain {
    public static void main(String[] args) {
        TemperatureScale[] temperatureScales = {new CelsiusConverter(), new FahrenheitConverter(), new KelvinConverter(),
                new ReaumurConverter(), new RankinConverter()};

        View view = new FrameView(temperatureScales);

        view.startApplication();
    }
}