package ru.academits.oop.asher.main;

import ru.academits.oop.asher.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(1, 3);
        System.out.println("Длина первого интервала: " + range1.getLength());
        Range range2 = new Range(1, 5);
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
        intersection.print();

        Range[] union = range1.getUnion(range2);
        System.out.println("Результат объединения интервалов: ");
        for (Range range : union) {
            range.print();
        }

        Range[] difference = range1.getDifference(range2);
        System.out.println("Результат разности интервалов: ");
        for (Range range : difference) {
            range.print();
        }
    }
}
