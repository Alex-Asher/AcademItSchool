package ru.academits.oop.asher.vector_task.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Первый конструктор, принимающий размерность n
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше нуля.");
        }
        this.components = new double[n];
    }

    // Второй конструктор - конструктор копирования
    public Vector(Vector vector) {
        this.components = vector.components;
    }

    // Третий конструктор, принимающий массив components
    public Vector(double[] components) {
        this.components = components;
    }

    // Четвёртый конструктор, принимающий размерность n и массив components
    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше нуля.");
        }

        if (n == components.length) {
            this.components = components;
        } else {
            double[] newComponents = new double[n];
            for (int i = 0; i < components.length; i++) {
                newComponents[i] = components[i];
            }
            for (int i = components.length; i < n; i++) {
                newComponents[i] = 0;
            }
            this.components = newComponents;
        }
    }

    // Геттеры и сеттеры для поля components
    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
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

    // Статический метод для сложения векторов
    public static Vector getSum(Vector vector1, Vector vector2) {
        if (vector1.components.length == vector2.components.length) {
            double[] newComponents = new double[vector1.components.length];

            for (int i = 0; i < vector1.components.length; i++) {
                newComponents[i] = vector1.components[i] + vector2.components[i];
            }

            return new Vector(newComponents);
        }

        int maxLength = Math.max(vector1.components.length, vector2.components.length);
        int minLength = Math.min(vector1.components.length, vector2.components.length);

        double[] newComponents = new double[maxLength];

        for (int i = 0; i < minLength; i++) {
            newComponents[i] = vector1.components[i] + vector2.components[i];
        }

        for (int i = minLength; i < maxLength; i++) {
            if (vector1.components.length == maxLength) {
                newComponents[i] = vector1.components[i];
            } else {
                newComponents[i] = vector2.components[i];
            }
        }

        return new Vector(newComponents);
    }

    // Нестатический метод для сложения векторов
    public Vector getSum(Vector vector) {
        if (this.components.length == vector.components.length) {
            double[] newComponents = new double[this.components.length];

            for (int i = 0; i < this.components.length; i++) {
                newComponents[i] = this.components[i] + vector.components[i];
            }

            return new Vector(newComponents);
        }

        int maxLength = Math.max(this.components.length, vector.components.length);
        int minLength = Math.min(this.components.length, vector.components.length);

        double[] newComponents = new double[maxLength];

        for (int i = 0; i < minLength; i++) {
            newComponents[i] = this.components[i] + vector.components[i];
        }

        for (int i = minLength; i < maxLength; i++) {
            if (this.components.length == maxLength) {
                newComponents[i] = this.components[i];
            } else {
                newComponents[i] = vector.components[i];
            }
        }

        return new Vector(newComponents);
    }

    // Статический метод для вычитания векторов (vector1 - vector2)
    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1.components.length == vector2.components.length) {
            double[] newComponents = new double[vector1.components.length];

            for (int i = 0; i < vector1.components.length; i++) {
                newComponents[i] = vector1.components[i] - vector2.components[i];
            }

            return new Vector(newComponents);
        }

        int maxLength = Math.max(vector1.components.length, vector2.components.length);
        int minLength = Math.min(vector1.components.length, vector2.components.length);

        double[] newComponents = new double[maxLength];

        for (int i = 0; i < minLength; i++) {
            newComponents[i] = vector1.components[i] - vector2.components[i];
        }

        for (int i = minLength; i < maxLength; i++) {
            if (vector1.components.length == maxLength) {
                newComponents[i] = vector1.components[i];
            } else {
                newComponents[i] = 0 - vector2.components[i];
            }
        }

        return new Vector(newComponents);
    }

    // Нестатический метод для вычитания векторов (this - vector)
    public Vector getDifference(Vector vector) {
        if (this.components.length == vector.components.length) {
            double[] newComponents = new double[this.components.length];

            for (int i = 0; i < this.components.length; i++) {
                newComponents[i] = this.components[i] - vector.components[i];
            }

            return new Vector(newComponents);
        }

        int maxLength = Math.max(this.components.length, vector.components.length);
        int minLength = Math.min(this.components.length, vector.components.length);

        double[] newComponents = new double[maxLength];

        for (int i = 0; i < minLength; i++) {
            newComponents[i] = this.components[i] - vector.components[i];
        }

        for (int i = minLength; i < maxLength; i++) {
            if (this.components.length == maxLength) {
                newComponents[i] = this.components[i];
            } else {
                newComponents[i] = 0 - vector.components[i];
            }
        }

        return new Vector(newComponents);
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
    public Vector multiplyByScalar(double scalar) {
        double[] newComponents = new double[this.components.length];

        for (int i = 0; i < this.components.length; i++) {
            newComponents[i] = this.components[i] * scalar;
        }

        return new Vector(newComponents);
    }

    // Нестатический метод для разворота вектора
    public Vector expand() {
        double[] newComponents = new double[this.components.length];

        for (int i = 0; i < this.components.length; i++) {
            newComponents[i] = this.components[i] * -1;
        }

        return new Vector(newComponents);
    }

    // Нестатический метод для получения длины вектора
    public double getLength() {
        double vectorLength = 0;

        for (double component : this.components) {
            vectorLength += Math.pow(component, 2);
        }

        return Math.sqrt(vectorLength);
    }

    // Нестатический метод для получения и установки компоненты вектора по индексу
    public void setComponent(double component, int index) {
        this.components[index] = component;
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
        return components.length == vector.components.length && components == vector.components;
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
