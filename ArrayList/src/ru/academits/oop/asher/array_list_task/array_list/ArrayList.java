package ru.academits.oop.asher.array_list_task.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] items;
    private int length;
    // Переменная modCount считает число изменений списка любыми методами
    private int modCount;

    public ArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[10];
        length = 0;
    }

    public ArrayList(int capacity) {
        //noinspection unchecked
        items = (E[]) new Object[capacity];
        length = 0;
    }

    // (1) Метод для расширения массива в два раза
    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    // (2) Метод для добавления элемента в конец списка
    @Override
    public boolean add(E element) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = element;
        length++;
        modCount++;
        return true;
    }

    // (3) Метод для вставки элемента по индексу
    @Override
    public void add(int index, E element) {
        if (length >= items.length) {
            increaseCapacity();
        }
        if (index == length) {
            items[length] = element;
        } else {
            for (int i = length - 1; i != index; i++) {
                items[i + 1] = items[i];
            }
        }
        length++;
        modCount++;
    }

    // (4) Метод для получения элемента по индексу
    @Override
    public E get(int index) {
        return items[index];
    }

    // (5) Метод для установки элемента по индексу
    @Override
    public E set(int index, E element) {
        items[index] = element;
        return element;
    }

    // (6) Метод для получения размера списка
    @Override
    public int size() {
        return length;
    }

    // (7) Метод, дающий информацию о том, является ли список пустым
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    // (8) Метод, дающий информацию о том, содержит ли список нужный объект
    @Override
    public boolean contains(Object object) {
        for (E item : items) {
            if (Objects.equals(item, object)) {
                return true;
            }
        }
        return false;
    }

    // (9) Метод, удаляющий объект по индексу
    @Override
    public E remove(int index) {
        E removedElement = items[index];
        if (index != length) {
            for (int i = index; i != length - 1; i++) {
                items[i] = items[i + 1];
            }
        }
        length--;
        modCount--;
        return removedElement;
    }

    // (10) Метод, удаляющий объект из списка
    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(items[i], object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    // (11) Метод, удаляющий все элементы из списка
    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            items[i] = null;
        }
    }

    // (12) Метод, который находит индекс элемента (первое вхождение)
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }
        return -1;
    }

    // (13) Метод, который находит индект элемента (последнее вхождение)
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length; i > 0; i--) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }
        return -1;
    }

    // (14) Метод, который возвращает массив со всеми элементами списка
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, length);
    }

    // (15) Метод, который заполняет массив всеми элементами списка
    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < length) {
            return (T[]) Arrays.copyOf(items, length);
        }

        System.arraycopy(items, 0, array, 0, length);
        if (array.length > length) {
            array[length] = null;
        }
        return array;
    }

    // (16) Метод, который гарантирует, что вместимость будет не меньше заданного числа
    void ensureCapacity(int capacity) {
        if (items.length < capacity) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    // (17) Метод, который делает массив такого же размера, как список
    public void trimToSize() {
        if (length < items.length) {
            items = Arrays.copyOf(items, length);
        }
    }

    // (18) Метод для распечатки списка
    // !!! Запомнить эту версию, она короче !!!
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < length; i++) {
            stringBuilder.append(items[i]);
            if (i < length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.append(']').toString();
    }

    // (19) Метод, который даёт информацию о том, содержит ли список все элементы переданной коллекции
    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    // (20) Метод, добавляющий в конец списка все элементы переданной коллекции
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        for (E element : collection) {
            if (length >= items.length) {
                increaseCapacity();
            }

            items[length] = element;
            length++;
            modCount++;
        }
        return true;
    }

    // (21) Метод, добавляющий все элементы переданной коллекции по указанному индексу
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        ensureCapacity(length - index + collection.size());
        System.arraycopy(items, index, items, index + collection.size(), length - index);

        int i = index;
        for (Object element : collection) {
            //noinspection unchecked
            items[i] = (E) element;
            i++;
        }
        length += collection.size();

        return true;
    }

    // (22) Метод, удаляющий из списка все элементы переданной коллекции
    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (collection.contains(items[i])) {
                remove(i);
                i--;
            }
        }
        return true;
    }

    // (23) Метод, сохраняющий в списке только те элементы, которые есть в переданной коллекции
    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!collection.contains(items[i])) {
                remove(i);
                i--;
            }
        }
        return true;
    }

    private class MyListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int saveModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция закончилась.");
            }
            if (saveModCount != modCount) {
                throw new ConcurrentModificationException("Список был изменен во время обхода итератором.");
            }
            ++currentIndex;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    // Метод не поддерживается
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    // Метод не поддерживается
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // Метод не поддерживается
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
