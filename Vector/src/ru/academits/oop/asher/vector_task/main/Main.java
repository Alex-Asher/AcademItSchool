package ru.academits.oop.asher.vector_task.main;

import ru.academits.oop.asher.vector_task.vector.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создание нового вектора vector1 с помощью первого конструктора: ");
        Vector vector1 = new Vector(4);
        System.out.println(vector1.toString());

        System.out.println("Создание нового вектора vector2 с помощью копирования vector1: ");
        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());

        System.out.println("Создание нового вектора vector3 с помощью третьего конструктора: ");
        double[] components3 = {2, 1, 3, 1};
        Vector vector3 = new Vector(components3);
        System.out.println(vector3.toString());

        System.out.println("Создание нового вектора vector4 с помощью четвертого конструктора: ");
        double[] components4 = {0, 5, 2, 3};
        Vector vector4 = new Vector(6, components4);
        System.out.println(vector4.toString());

        System.out.println("Получение размерности vector4: ");
        int size = vector4.getSize();
        System.out.println(size);

        System.out.println("Сложение векторов 3 и 4 нестатическим и статическим методами: ");
        vector3.add(vector4);
        System.out.println(vector3.toString());

        Vector vector5 = Vector.getSum(vector3, vector4);
        System.out.println(vector5.toString());

        System.out.println("Вычитание векторов 3 и 4 нестатическим и статическим методами: ");
        vector3.subtract(vector4);
        System.out.println(vector3.toString());

        Vector vector6 = Vector.getDifference(vector3, vector4);
        System.out.println(vector6.toString());

        System.out.println("Нахождение скалярного произведения векторов 3 и 4: ");
        double dotProduct = Vector.getDotProduct(vector3, vector4);
        System.out.println(dotProduct);

        System.out.println("Умножение вектора 3 на скаляр 2: ");
        vector3.multiplyByScalar(2);
        System.out.println(vector3.toString());

        System.out.println("Разворот вектора 3: ");
        vector3.invert();
        System.out.println(vector3.toString());

        System.out.println("Получение длины вектора 3: ");
        double length = vector3.getLength();
        System.out.println(length);

        System.out.println("Получение компоненты вектора по индексу: ");
        System.out.println(vector1.getComponent(2));

        System.out.println("Установка компоненты вектора по индексу: ");
        vector1.setComponent(2, 1);
        System.out.println(vector1.toString());

        System.out.println("Попытка создать вектор с отрицательной размерностью: ");
        Vector vector11 = new Vector(-2);
        System.out.println(vector11.toString());
    }
}
