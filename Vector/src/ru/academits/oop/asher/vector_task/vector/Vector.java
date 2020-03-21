package ru.academits.oop.asher.vector_task.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Первый конструктор, принимающий размерность "dimension"
    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше нуля.");
        }

        this.components = new double[dimension];
    }

    // Второй конструктор - конструктор копирования
    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.getSize());
    }

    // Третий конструктор, принимающий массив components
    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше нуля.");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    // Четвёртый конструктор, принимающий размерность n и массив components
    public Vector(int dimension, double[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше нуля.");
        }

        this.components = Arrays.copyOf(components, dimension);
    }

    // Метод для получения размерности вектора
    public int getSize() {
        return components.length;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");
        for (int i = 0; i < components.length - 1; i++) {
            stringBuilder.append(components[i])
                    .append(", ");
        }
        stringBuilder.append(components[components.length - 1])
                .append(" }");

        return stringBuilder.toString();
    }

    // Нестатический метод для сложения векторов (this + vector)
    public void add(Vector vector) {
        if (vector.components.length > this.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] += vector.components[i];
        }
    }

    // Статический метод для сложения векторов
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector copy = new Vector(vector1);
        copy.add(vector2);
        return copy;
    }

    // Нестатический метод для вычитания векторов (this - vector)
    public void subtract(Vector vector) {
        if (vector.components.length > this.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] -= vector.components[i];
        }
    }

    // Статический метод для вычитания векторов (vector1 - vector2)
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector copy = new Vector(vector1);
        copy.subtract(vector2);
        return copy;
    }

    // Статический метод для нахождения скалярного произведения ("dot product")
    public static double getDotProduct(Vector vector1, Vector vector2) {
        double dotProduct = 0;
        int minLength = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minLength; i++) {
            dotProduct += vector1.components[i] * vector2.components[i];
        }

        return dotProduct;
    }

    // Нестатический метод для умножения вектора на скаляр
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * scalar;
        }
    }

    // Нестатический метод для разворота вектора
    public void invert() {
        multiplyByScalar(-1);
    }

    // Нестатический метод для получения длины вектора
    public double getLength() {
        double squaresSum = 0;

        for (double component : components) {
            squaresSum += Math.pow(component, 2);
        }

        return Math.sqrt(squaresSum);
    }

    // Нестатический метод для получения компоненты вектора по индексу
    public double getComponent(int index) {
        return components[index];
    }

    // Нестатический метод для установки компоненты вектора по индексу
    public void setComponent(int index, double component) {
        components[index] = component;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Vector vector = (Vector) object;
        return Arrays.equals(components, vector.components);
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }
}
