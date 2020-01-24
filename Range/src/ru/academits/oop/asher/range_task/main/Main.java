package ru.academits.oop.asher.range_task.main;

import ru.academits.oop.asher.range_task.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(1, 5);
        System.out.print("Первый интервал: ");
        range1.print();
        System.out.println();

        Range range2 = new Range(3, 5);
        System.out.print("Второй интервал: ");
        range2.print();
        System.out.println();

        System.out.println("Длина первого интервала: " + range1.getLength());
        System.out.println("Длина второго интервала: " + range2.getLength());

        double number = 3;

        if (range1.isInside(number)) {
            System.out.println("Число " + number + " принадлежит первому интервалу.");
        } else {
            System.out.println("Число " + number + " не принадлежит первому интервалу.");
        }

        if (range2.isInside(number)) {
            System.out.println("Число " + number + " принадлежит второму интервалу.");
        } else {
            System.out.println("Число " + number + " не принадлежит второму интервалу.");
        }

        Range intersection = range1.getIntersection(range2);

        System.out.print("Результат пересечения интервалов: ");
        if (intersection != null) {
            intersection.print();
        } else {
            System.out.print("пересечения нет");
        }
        System.out.println();

        Range[] union = range1.getUnion(range2);

        System.out.print("Результат объединения интервалов: [");
        for (Range range : union) {
            range.print();
        }
        System.out.print("]");
        System.out.println();

        Range[] difference = range1.getDifference(range2);

        System.out.print("Результат разности интервалов: [");
        for (Range range : difference) {
            range.print();
        }
        System.out.print("]");
        System.out.println();
    }
}
