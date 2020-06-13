package ru.academits.oop.asher.list_task.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    // Получение размера списка
    public int getCount() {
        return count;
    }

    // Получение значения первого элемента
    public T getHead() {
        if (count == 0) {
            throw new NoSuchElementException("Вызов метода невозможен для пустого списка.");
        }

        return head.getData();
    }

    // Вспомогательный метод: добавление значения элемента в список
    public void add(T data) {
        if (count == 0) {
            insertFirst(data);
            return;
        }

        ListItem<T> lastElement = findElement(count - 1);
        ListItem<T> element = new ListItem<>(data);

        lastElement.setNext(element);
        count++;
    }

    // Вспомогательный метод: получение узла по индексу
    private ListItem<T> findElement(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }

        ListItem<T> element = head;

        for (int i = 0; i < index; i++) {
            element = element.getNext();
        }

        return element;
    }

    // Получение значения по указанному индексу
    public T getValue(int index) {
        return findElement(index).getData();
    }

    // Изменение значения по указанному индексу. Возвращается старое значение
    public T setValue(int index, T data) {
        ListItem<T> element = findElement(index);
        T oldData = element.getData();
        element.setData(data);

        return oldData;
    }

    // Удаление элемента по индексу. Возвращается значение элемента
    public T deleteElement(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> previousElement = findElement(index - 1);
        ListItem<T> element = previousElement.getNext();
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
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }

        if (index == 0) {
            insertFirst(data);
            return;
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
        if (count == 0) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            deleteFirst();
            return true;
        }

        if (count == 1) {
            return false;
        }

        ListItem<T> previousElement = head;
        ListItem<T> element = head.getNext();
        ListItem<T> nextElement = element.getNext();

        for (int i = 1; i < count; i++) {
            if (Objects.equals(element.getData(), data)) {
                previousElement.setNext(nextElement);
                count--;
                return true;
            }

            previousElement = previousElement.getNext();
            element = element.getNext();
            nextElement = nextElement.getNext();
        }

        return false;
    }

    // Удаление первого элемента. Возвращает значение элемента
    public T deleteFirst() {
        if (count == 0) {
            throw new NoSuchElementException("Вызов метода невозможен для пустого списка.");
        }

        ListItem<T> oldHead = head;
        head = head.getNext();
        count--;
        return oldHead.getData();
    }

    // Разворот списка за линейное время
    public void reverse() {
        if (count == 0) {
            return;
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

    // Копирование списка
    public SinglyLinkedList<T> copy() {
        if (count == 0) {
            new SinglyLinkedList<>();
        }

        if (count == 1) {
            SinglyLinkedList<T> copy = new SinglyLinkedList<>();
            copy.insertFirst(head.getData());
            return copy;
        }

        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        copy.insertFirst(head.getData());

        ListItem<T> element = head.getNext();
        ListItem<T> copyElement = copy.head;

        for (int i = 1; i < count; i++) {
            ListItem<T> newCopyElement = new ListItem<>(element.getData());
            copyElement.setNext(newCopyElement);

            element = element.getNext();
            copyElement = newCopyElement;
        }

        copy.count = count;
        return copy;
    }

    // Вспомогательный метод: переопределение toString
    @Override
    public String toString() {
        if (count == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        ListItem<T> element = head;

        for (int i = 0; i < count - 1; i++) {
            stringBuilder.append(element.getData())
                    .append(", ");
            element = element.getNext();
        }

        stringBuilder.append(element.getData())
                .append("}");

        return stringBuilder.toString();
    }
}
