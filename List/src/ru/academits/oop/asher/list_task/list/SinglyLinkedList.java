package ru.academits.oop.asher.list_task.list;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    // Получение размера списка
    public int getCount() {
        return count;
    }

    // Получение значения первого элемента
    public T getHead() {
        if (count == 0) {
            throw new IllegalArgumentException("Вызов метода невозможен для пустого списка.");
        }

        return head.getData();
    }

    // Вспомогательный метод: добавление значения элемента в список
    public void add(T data) {
        if (count == 0) {
            insertFirst(data);
        } else {
            ListItem<T> lastElement = findElement(count - 1);
            ListItem<T> element = new ListItem<>(data);

            lastElement.setNext(element);
            count++;
        }
    }

    // Вспомогательный метод: получение узла по индексу
    private ListItem<T> findElement(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным числом.");
        }

        ListItem<T> element = head;
        for (int i = 0; i < index; i++) {
            element = element.getNext();
        }
        return element;
    }

    // Получение значения по указанному индексу
    public T getValue(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным числом.");
        }

        return findElement(index).getData();
    }

    // Изменение значения по указанному индексу. Возвращается старое значение
    public T setValue(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным числом.");
        }

        T oldData = findElement(index).getData();
        findElement(index).setData(data);
        return oldData;
    }

    // Удаление элемента по индексу. Возвращается значение элемента
    public T deleteElement(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным числом.");
        }

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> previousElement = findElement(index - 1);
        ListItem<T> element = findElement(index);
        ListItem<T> nextElement = element.getNext();

        previousElement.setNext(nextElement);
        count--;
        return element.getData();
    }

    // Вставка элемента в начало
    public void insertFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    // Вставка элемента по индексу
    public void insertElement(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным числом.");
        }

        ListItem<T> previousElement = findElement(index - 1);
        ListItem<T> element = new ListItem<>(data);
        ListItem<T> nextElement = previousElement.getNext();

        element.setNext(nextElement);
        previousElement.setNext(element);
        count++;
    }

    // Удаление узла по значению. Выдаёт true, если элемент был удалён
    public boolean deleteElement(T data) {
        if (Objects.equals(head.getData(), data)) {
            deleteFirst();
            return true;
        }

        ListItem<T> element = head.getNext();
        for (int i = 1; i < count; i++) {
            if (Objects.equals(element.getData(), data)) {
                findElement(i - 1).setNext(findElement(i + 1));
                count--;
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    // Удаление первого элемента. Возвращает значение элемента
    public T deleteFirst() {
        if (count == 0) {
            throw new IllegalArgumentException("Вызов метода невозможен для пустого списка.");
        }

        ListItem<T> oldHead = head;
        head = head.getNext();
        count--;
        return oldHead.getData();
    }

    // Разворот списка за линейное время
    public void reverse() {
        if (count == 0) {
            throw new IllegalArgumentException("Вызов метода невозможен для пустого списка.");
        }

        ListItem<T> previousElement = null;
        ListItem<T> element = head;
        ListItem<T> nextElement = head.getNext();

        while (nextElement != null) {
            element.setNext(previousElement);
            previousElement = element;
            element = nextElement;
            nextElement = nextElement.getNext();
        }

        element.setNext(previousElement);
        head = element;
    }

    public SinglyLinkedList<T> copy() {
        if (count == 0) {
            throw new IllegalArgumentException("Вызов метода невозможен для пустого списка.");
        }

        SinglyLinkedList<T> copy = new SinglyLinkedList<>();

        for (int i = 0; i < count; i++) {
            copy.add(findElement(i).getData());
        }

        copy.count = count;
        return copy;
    }

    // Вспомогательный метод: переопределение toString
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (int i = 0; i < count - 1; i++) {
            stringBuilder.append(findElement(i).getData())
                    .append(", ");
        }

        stringBuilder.append(findElement(count - 1).getData())
                .append("}");

        return stringBuilder.toString();
    }
}
