package ru.academits.oop.asher.array_list_home_task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Часть 1: чтение строк из файла и запись их в список
        ArrayList<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome.txt"))) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }

        System.out.println(strings);

        // Часть 2: удаление всех чётных чисел из списка целых чисел
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }

        System.out.println(numbers);

        // Часть 3: создание списка без повторов
        ArrayList<Integer> listWithRepeats = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 6, 7));
        ArrayList<Integer> listWithoutRepeats = new ArrayList<>();
        listWithoutRepeats.ensureCapacity(listWithRepeats.size());

        for (Integer element : listWithRepeats) {
            if (!listWithoutRepeats.contains(element)) {
                listWithoutRepeats.add(element);
            }
        }

        System.out.println(listWithRepeats);
        System.out.println(listWithoutRepeats);
    }
}
