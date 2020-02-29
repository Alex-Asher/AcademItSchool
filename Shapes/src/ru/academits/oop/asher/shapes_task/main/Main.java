package ru.academits.oop.asher.shapes_task.main;

import ru.academits.oop.asher.shapes_task.comparators.*;
import ru.academits.oop.asher.shapes_task.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape findShapeWithMaxArea(Shape[] shapes) {
        AreaComparator areaComparator = new AreaComparator();
        Arrays.sort(shapes, areaComparator);
        return shapes[shapes.length - 1];
    }

    public static Shape findShapeWithSecondMaxPerimeter(Shape[] shapes) {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        Arrays.sort(shapes, perimeterComparator);
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Square square1 = new Square(2);
        Square square2 = new Square(3);
        Square square3 = new Square(4);

        Triangle triangle1 = new Triangle(1, 4, 5, 1, 2, 5);
        Triangle triangle2 = new Triangle(2, 8, 10, 2, 4, 10);

        Rectangle rectangle1 = new Rectangle(2, 4);
        Rectangle rectangle2 = new Rectangle(3, 2);
        Rectangle rectangle3 = new Rectangle(4, 8);

        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(4);

        Shape[] myShapes = {square1, square2, square3, triangle1, triangle2, rectangle1, rectangle2, rectangle3,
                circle1, circle2};

        Shape shapeWithMaxArea = findShapeWithMaxArea(myShapes);
        System.out.println(shapeWithMaxArea.toString());

        Shape shapeWithSecondMaxPerimeter = findShapeWithSecondMaxPerimeter(myShapes);
        System.out.println(shapeWithSecondMaxPerimeter.toString());
    }
}
