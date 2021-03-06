package ru.academits.oop.asher.range_task.range;

public class Range {
    private double from;
    private double to;

    // Примечание (для себя): в этой задаче мы считаем, что from всегда передают меньше, чем to
    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    // Примечание (для себя): в этой задаче модуль не используем
    public double getLength() {
        return to - from;
    }

    // Примечание (для себя): в этой задаче не используем сравнение через epsilon
    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public boolean hasIntersection(Range range) {
        return from < range.to && range.from < to;
    }

    // Примечание (для себя): в этой задаче считаем, что если у отрезков одна общая точка, то они НЕ пересекаются
    public Range getIntersection(Range range) {
        if (hasIntersection(range)) {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }

        return null;
    }

    // Примечание (для себя): в объединении, если отрезки пересекаются по одному концу, пересечение есть
    public Range[] getUnion(Range range) {
        if (from <= range.to && range.from <= to) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }

        return new Range[]{new Range(from, to), new Range(range.from, range.to)};
    }

    public Range[] getDifference(Range range) {
        if (!hasIntersection(range)) {
            return new Range[]{new Range(from, to)};
        }
        if (from >= range.from && to <= range.to) {
            return new Range[0];
        }
        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }
        if (from < range.from && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(range.to, to)};
    }

    public void print() {
        System.out.print("(" + from + "; " + to + ")");
    }
}