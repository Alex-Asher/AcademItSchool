package ru.academits.oop.asher.shapes_task.shapes;

public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getWidth() {
        return 2 * r;
    }

    public double getHeight() {
        return 2 * r;
    }

    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    public String toString() {
        return "Окружность с радиусом " + r;
    }

    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || object.getClass() != this.getClass()) return false;
        Circle circle = (Circle) object;
        return r == circle.r;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(r);
        return hash;
    }
}
