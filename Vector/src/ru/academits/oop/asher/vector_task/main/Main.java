package ru.academits.oop.asher.vector_task.main;

import ru.academits.oop.asher.vector_task.vector.Vector;

public class Main {
    public static void main(String[] args) {
        // Создание нового вектора vector1 с помощью первого конструктора
        Vector vector1 = new Vector(4);
        System.out.println(vector1.toString());

        // Создание нового вектора vector2 с помощью копирования vector1
        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());

        // Создание нового вектора vector3 с помощью третьего конструктора
        double[] components = {2, 1, 3};
        Vector vector3 = new Vector(components);
        System.out.println(vector3.toString());

        // Создание нового вектора vector4 с помощью четвертого конструктора
        Vector vector4 = new Vector(4, components);
        System.out.println(vector4.toString());

        // Получение размерности vector1
        int size = vector1.getSize();
        System.out.println(size);

        // Сложение векторов статическим и нестатическим методами
        Vector vector5 = Vector.getSum(vector3, vector4);
        System.out.println(vector5.toString());

        Vector vector6 = vector3.getSum(vector4);
        System.out.println(vector6.toString());

        // Вычитание векторов статическим и нестатическим методами
        Vector vector7 = Vector.getDifference(vector3, vector4);
        System.out.println(vector7.toString());

        Vector vector8 = vector3.getDifference(vector4);
        System.out.println(vector8.toString());

        // Нахождение скалярного произведения
        double dotProduct = Vector.getDotProduct(vector3, vector4);
        System.out.println(dotProduct);

        // Умножение вектора на скаляр
        Vector vector9 = vector3.multiplyByScalar(2);
        System.out.println(vector9.toString());

        // Разворот вектора
        Vector vector10 = vector9.expand();
        System.out.println(vector10.toString());

        // Получение длины вектора
        double length = vector3.getLength();
        System.out.println(length);

        // Получение и установка компоненты вектора по индексу
        vector1.setComponent(2, 1);
        System.out.println(vector1.toString());

        // Попытка создать вектор с отрицательной размерностью
        Vector vector11 = new Vector(-2);
        System.out.println(vector11.toString());
    }
}
