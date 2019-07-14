package ru.academits.oop.asher.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    private double getLength() {
        return to - from;
    }

    private boolean isInside(double number) {
        double epsilon = 0.0000000001;
        return from - number <= epsilon && number - to <= epsilon;
    }

    private Range getIntersection(Range range) {
        if (from >= range.to || range.from >= to) {
            return null;
        }
        if (from <= range.from && to >= range.to) {
            System.out.println(range.from + " " + range.to);
            return new Range(range.from, range.to);
        }
        if (from > range.from && to < range.to) {
            System.out.println(from + " " + to);
            return new Range(from, to);
        }
        if (from <= range.to && to >= range.from) {
            System.out.println(range.from + " " + to);
            return new Range(range.from, to);
        }
        System.out.println(from + " " + range.to);
        return new Range(from, range.to);
    }

    private Range[] getUnion(Range range) {
        if (from > range.to || range.from > to) {
            System.out.println(from + " " + to);
            System.out.println(range.from + " " + range.to);
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }
        if (from <= range.from && to >= range.to) {
            System.out.println(range.from + " " + range.to);
            return new Range[]{new Range(range.from, range.to)};
        }
        if (from > range.from && to < range.to) {
            System.out.println(from + " " + to);
            return new Range[]{new Range(from, to)};
        }
        if (from <= range.to && to >= range.from) {
            System.out.println(from + " " + range.to);
            return new Range[]{new Range(from, range.to)};
        }
        System.out.println(from + " " + range.to);
        return new Range[]{new Range(from, range.to)};
    }

    private Range[] getDifference(Range range) {
        if (from > range.to || range.from > to) {
            System.out.println(from + " " + to);
            return new Range[]{new Range(from, to)};
        }
        if (from <= range.from && to >= range.to) {
            System.out.println(0);
            return new Range[0];
        }
        if (from > range.from && to < range.to) {
            System.out.println(from + " " + range.from);
            System.out.println(range.to + " " + to);
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }
        if (from <= range.to && to >= range.from) {
            System.out.println(from + " " + range.from);
            return new Range[]{new Range(from, range.from)};
        }
        System.out.println(range.to + " " + to);
        return new Range[]{new Range(range.to, to)};
    }

    public static void main(String[] args) {
        Range range1 = new Range(3, 7);
        System.out.println("Длина первого интервала: " + range1.getLength());
        Range range2 = new Range(4, 9);
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

        System.out.println("Результат пересечения интервалов:");
        Range intersection = range1.getIntersection(range2);
        System.out.println("Результат объединения интервалов:");
        Range[] union = range1.getUnion(range2);
        System.out.println("Результат разности интервалов:");
        Range[] difference = range1.getDifference(range2);
    }
}