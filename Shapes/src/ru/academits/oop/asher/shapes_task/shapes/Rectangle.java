package ru.academits.oop.asher.shapes_task.shapes;

public class Rectangle implements Shape {
    private double x;
    private double y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return Math.min(x, y);
    }

    public double getHeight() {
        return Math.max(x, y);
    }

    public double getArea() {
        return x * y;
    }

    public double getPerimeter() {
        return 2 * x + 2 * y;
    }

    public String toString() {
        return "Прямоугольник с длинами сторон " + x + " и " + y;
    }

    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        Rectangle rectangle = (Rectangle) object;
        return x == rectangle.x && y == rectangle.y;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x);
        hash = prime * hash + Double.hashCode(y);
        return hash;
    }
}
