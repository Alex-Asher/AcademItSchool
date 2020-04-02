package ru.academits.oop.asher.list_task.main;

import ru.academits.oop.asher.list_task.list.ListItem;
import ru.academits.oop.asher.list_task.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        ListItem<String> element4 = new ListItem<>("помидоры");
        ListItem<String> element3 = new ListItem<>("молоко", element4);
        ListItem<String> element2 = new ListItem<>("гречка", element3);
        ListItem<String> element1 = new ListItem<>("картошка", element2);

        SinglyLinkedList<String> products = new SinglyLinkedList<>(element1, 4);

        // Получение размера списка
        System.out.println("Список покупок: " + products);
        System.out.println("Размер этого списка: " + products.getCount());

        // Получение значения первого элемента
        ListItem<String> head = products.getHead();
        System.out.println("Первый элемент этого списка: " + head.getData());

        // Получение значения по указанному индексу
        String thirdProduct = products.getValue(2);
        System.out.println("Третий элемент этого списка: " + thirdProduct);

        // Изменение значения по указанному индексу. Возвращается старое значение
        String changedProduct = products.setValue(2, "лук");
        System.out.println("Этот продукт мы решили заменить на другой: " + changedProduct);
        System.out.println("Теперь список выглядит так: " + products);

        // Удаление элемента по индексу. Возвращается значение элемента
        String deletedElement = products.deleteElement(1);
        System.out.println("От покупки этого продукта мы решили отказаться: " + deletedElement);
        System.out.println("Теперь список выглядит так: " + products);

        // Вставка элемента в начало
        System.out.println("Мы передумали и решили сделать этот продукт первым в списке.");
        products.insertFirst("гречка");
        System.out.println("Теперь список выглядит так: " + products);

        // Вставка элемента по индексу
        System.out.println("Мы решили добавить в список новый продукт.");
        products.insertElement(2, "курица");
        System.out.println("Теперь список выглядит так: " + products);

        // Удаление узла по значению. Выдаёт true, если элемент был удалён
        System.out.println("Мы передумали покупать один из продуктов.");
        boolean productIsDeleted = products.deleteElement("лук");
        if (productIsDeleted) {
            System.out.println("Лук удалён из списка покупок.");
        } else {
            System.out.println("Лук не был удалён из списка покупок.");
        }
        System.out.println("Теперь список выглядит так: " + products);

        // Удаление первого элемента. Возвращает значение элемента
        System.out.println("Мы всё-таки вычеркнули из списка первый пункт.");
        String deletedFirst = products.deleteFirst();
        System.out.println("Из списка был удалён элемент: " + deletedFirst);
        System.out.println("Теперь список выглядит так: " + products);

        // Разворот списка за линейное время
        System.out.println("Мы решили развернуть список в обратную сторону.");
        products.reverseList();
        System.out.println("Теперь список выглядит так: " + products);

        // Копирование списка
        System.out.println("Мы решили копировать этот список.");
        SinglyLinkedList<String> copy = products.copyList();
        System.out.println("Копия выглядит так: " + copy);
    }
}
