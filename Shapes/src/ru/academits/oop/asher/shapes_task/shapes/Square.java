package ru.academits.oop.asher.shapes_task.shapes;

public class Square implements Shape {
    private double x;

    public Square(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getWidth() {
        return x;
    }

    public double getHeight() {
        return x;
    }

    public double getArea() {
        return 2 * x;
    }

    public double getPerimeter() {
        return 4 * x;
    }

    public String toString() {
        return "Квадрат с длиной стороны " + x;
    }

    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        Square square = (Square) object;
        return x == square.x;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x);
        return hash;
    }
}
