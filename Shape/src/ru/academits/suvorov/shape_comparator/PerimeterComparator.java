package ru.academits.suvorov.shape_comparator;

import ru.academits.suvorov.shape_interface.ShapeInterface;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<ShapeInterface> {

    @Override
    public int compare(ShapeInterface o1, ShapeInterface o2) {
        if (o1 != null && o2 != null) {
            if (o1.getPerimeter() < o2.getPerimeter()) {
                return -1;
            }
            if (o1.getPerimeter() == o2.getPerimeter()) {
                return 0;
            }
            if (o1.getPerimeter() > o2.getPerimeter()) {
                return 1;
            }
        }

        return 0;
    }
}