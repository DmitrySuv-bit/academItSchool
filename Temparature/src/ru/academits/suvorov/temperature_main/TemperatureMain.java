package ru.academits.suvorov.temperature_main;

import ru.academits.suvorov.controller.Controller;
import ru.academits.suvorov.temperature_view.FrameView;
import ru.academits.suvorov.view.View;

public class TemperatureMain {
    public static void main(String[] args) {
        View view = new FrameView();

        Controller controller = new Controller(view);

        controller.convertTemperature();
    }
}
