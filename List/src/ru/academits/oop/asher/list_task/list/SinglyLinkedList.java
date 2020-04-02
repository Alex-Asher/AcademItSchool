package ru.academits.oop.asher.list_task.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(ListItem<T> head, int count) {
        this.head = head;
        this.count = count;
    }

    // Получение размера списка
    public int getCount() {
        return count;
    }

    // Получение значения первого элемента
    public ListItem<T> getHead() {
        return head;
    }

    // Получение значения по указанному индексу
    public T getValue(int index) {
        ListItem<T> element = head;
        for (int i = 0; i < index; i++) {
            element = element.getNext();
        }

        return element.getData();
    }

    // Изменение значения по указанному индексу. Возвращается старое значение
    public T setValue(int index, T data) {
        ListItem<T> element = head;
        for (int i = 0; i < index; i++) {
            element = element.getNext();
        }

        T oldData = element.getData();
        element.setData(data);
        return oldData;
    }

    // Удаление элемента по индексу. Возвращается значение элемента
    public T deleteElement(int index) {
        ListItem<T> previousElement = head;
        for (int i = 0; i < index - 1; i++) {
            previousElement = previousElement.getNext();
        }

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
        ListItem<T> previousElement = head;
        for (int i = 0; i < index - 1; i++) {
            previousElement = previousElement.getNext();
        }
        ListItem<T> nextElement = previousElement.getNext();

        ListItem<T> element = new ListItem<>(data);
        element.setNext(nextElement);
        previousElement.setNext(element);
        count++;
    }

    // Удаление узла по значению. Выдаёт true, если элемент был удалён
    public boolean deleteElement(T data) {
        ListItem<T> element = head;
        for (int i = 0; i < count; i++) {
            if (element.getData() == data) {
                deleteElement(i);
                return true;
            } else {
                element = element.getNext();
            }
        }
        return false;
    }

    // Удаление первого элемента. Возвращает значение элемента
    public T deleteFirst() {
        ListItem<T> oldHead = head;
        head = head.getNext();
        count--;
        return oldHead.getData();
    }

    // Разворот списка за линейное время
    public void reverseList() {
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
    public SinglyLinkedList<T> copyList() {
        return new SinglyLinkedList<>(getHead(), getCount());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListItem<T> element = head;

        for (int i = 0; i < count - 1; i++) {
            stringBuilder.append(element.getData())
                    .append(", ");
            element = element.getNext();
        }
        stringBuilder.append(element.getData());

        return stringBuilder.toString();
    }
}
