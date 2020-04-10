package ru.academits.oop.asher.csv_task.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestCSV {
    public static void changeCSVToHTML(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("CSV.csv"));
             PrintWriter writer = new PrintWriter("CSV.html")) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");

            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\">");
            writer.println("<title>My table</title>");
            writer.println("</head>");

            writer.println("<body>");
            writer.println("<table border=\"1\">");

            boolean quotesAreHere = false;

            while (scanner.hasNextLine()) {
                String currentString = scanner.nextLine();

                // Если строка новая и кавычки уже были, то мы в той же ячейке и печатаем перевод строки
                // Если строка новая и кавычек ещё не было, то мы объявляем новую строку таблицы
                if (quotesAreHere) {
                    writer.print("<br/>");
                } else {
                    writer.println("<tr>");
                    writer.print("<td>");
                }

                // Идём по символам текущей строки
                for (int i = 0; i < currentString.length(); i++) {
                    char currentChar = currentString.charAt(i);

                    // Сделаем проверки на символы <, >, &
                    if (currentChar == '<') {
                        writer.print("&lt;");
                    } else if (currentChar == '>') {
                        writer.print("&gt;");
                    } else if (currentChar == '&') {
                        writer.print("&amp;");
                        // Сделаем проверку на кавычку
                    } else if (currentChar == '"') {
                        // Если видим кавычку и она уже была раньше, то меняем переменную на false
                        if (quotesAreHere) {
                            quotesAreHere = false;
                        } else {
                            // Если видим кавычку и её раньше не было, то меняем переменную на true
                            quotesAreHere = true;
                            // А затем, если предыдущий символ тоже кавычка, печатаем кавычку
                            if (i != 0) {
                                if (currentString.charAt(i - 1) == '"') {
                                    writer.print('"');
                                }
                            }
                        }
                        // Сделаем проверку на запятую
                    } else if (currentChar == ',') {
                        // Если есть незакрытые кавычки, то мы ещё в этой ячейке, печатаем запятую
                        if (quotesAreHere) {
                            writer.print(", ");
                        } else {
                            // Если незакрытых кавычек нет, то мы объявляем переход к следующей ячейке
                            writer.print("</td><td>");
                        }
                    } else {
                        // Если мы не зашли ни в какой из if'ов, то символ обычный и мы его просто печатаем
                        writer.print(currentChar);
                    }
                }

                // Если к концу строки не осталось незакрытых кавычек, то объявляем новую строку
                if (!quotesAreHere) {
                    writer.println("</td>");
                    writer.println("</tr>");
                }
            }

            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при попытке чтения CSV файла.");
        }
    }
}
