package ru.academits.suvorov.shape_comparator;

import ru.academits.suvorov.shape_interface.ShapeInterface;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<ShapeInterface> {
    @Override
    public int compare(ShapeInterface o1, ShapeInterface o2) {
        return Double.compare(o1.getPerimeter(), o2.getPerimeter());
    }
}