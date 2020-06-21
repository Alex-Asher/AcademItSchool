package ru.academits.oop.asher.array_list_task.main;

import ru.academits.oop.asher.array_list_task.array_list.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создадим список из элементов 1, 2, 3, 4, 5: ");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println(numbers);

        /* System.out.println("Добавим число 6 по индексу 2: ");
        numbers.add(2, 6);
        System.out.println(numbers); */

        System.out.println("Получим элемент с индексом 3: ");
        int element = numbers.get(3);
        System.out.println(element);

        System.out.println("Поставим по индексу 3 элемент 9: ");
        int newElement = numbers.set(3, 9);
        System.out.println(newElement);
        System.out.println(numbers);

        System.out.println("Узнаем размер списка: ");
        System.out.println(numbers.size());

        System.out.println("Узнаем, является ли список пустым: ");
        if (numbers.isEmpty()) {
            System.out.println("список пуст.");
        } else {
            System.out.println("список не пуст.");
        }

        System.out.println("Узнаем, есть ли в списке число 4: ");
        if (numbers.contains(4)) {
            System.out.println("в списке есть число 4.");
        } else {
            System.out.println("в списке нет числа 4.");
        }

        System.out.println("Удалим из списка число с индексом 2: ");
        numbers.remove(2);
        System.out.println(numbers);

        // Почему используется не тот метод?
        /* System.out.println("Удалим из списка число 9: ");
        if (numbers.remove(9)) {
            System.out.println("число 9 удалено из списка.");
        } else {
            System.out.println("число 9 не удалено из списка.");
        }
        System.out.println(numbers); */

        System.out.println("Очистим список: ");
        numbers.clear();
        System.out.println(numbers);

        System.out.println("Заполним список элементами 2, 9, 7, 2, 4, 5: ");
        numbers.set(0, 2);
        numbers.set(1, 9);
        numbers.set(2, 7);
        numbers.set(3, 2);
        numbers.add(4);
        numbers.add(5);
        System.out.println(numbers);

        System.out.println("Найдём индекс первого вхождения элемента 2: ");
        System.out.println(numbers.indexOf(2));

        System.out.println("Найдём индекс последнего вхождения элемента 2: ");
        System.out.println(numbers.lastIndexOf(2));

        System.out.println("Распечатаем массив со всеми элементами списка: ");
        System.out.println(Arrays.toString(numbers.toArray()));

        System.out.println("Распечатаем массив со всеми элементами списка: ");
        Integer[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(numbers.toArray(array)));

        System.out.println("Создадим коллекцию из элементов 1, 3: ");
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(3);
        System.out.println(collection);

        System.out.println("Проверим, содержит ли список все элементы коллекции: ");
        if (numbers.containsAll(collection)) {
            System.out.println("список содержит все элементы коллекции.");
        } else {
            System.out.println("список не содержит все элементы коллекции.");
        }

        System.out.println("Добавим коллекцию в конец списка: ");
        numbers.addAll(collection);
        System.out.println(numbers);

        System.out.println("Добавим коллекцию в список по индексу 2: ");
        numbers.addAll(2, collection);
        System.out.println(numbers);

        System.out.println("Сохраним в списке только те элементы, которые есть в коллекции: ");
        numbers.retainAll(collection);
        System.out.println(numbers);

        System.out.println("Удалим из списка все элементы коллекции: ");
        numbers.removeAll(collection);
        System.out.println(numbers);
    }
}
