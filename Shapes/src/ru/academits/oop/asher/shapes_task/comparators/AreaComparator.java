package ru.academits.oop.asher.shapes_task.comparators;

import ru.academits.oop.asher.shapes_task.shapes.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape2.getArea(), shape1.getArea());
    }
}
