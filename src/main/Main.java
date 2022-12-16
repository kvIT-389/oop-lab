import java.util.Locale;
import java.util.Random;

import con.Console;
import ext.ExtendedArray;
import ext.ExtendedString;
import menu.Menu;


public class Main {
    private static Random rand = new Random();

    public static void main(String[] args)
    {
        Menu mainMenu = new Menu("Выберите действие:");

        mainMenu.addEntry(
            "A", "Запустить решение задачи A",
            () -> {
                Console.clear();

                Integer size = Console.readInteger(
                    "Введите размер массива N (2 <= N <= 10)",
                    2, 10
                );

                ExtendedArray array = new ExtendedArray();

                for (int i = 0; i < size; ++i) {
                    Double new_el = Math.round(
                        (rand.nextDouble() * 100.0 - 50.0) * 10.0
                    ) / 10.0;

                    array.add(new_el);
                }

                Console.printLine("Сгенерированный массив:");
                Console.printLine(array);
                Console.printLine();

                Double arg = Console.readDouble("Введите второй операнд");
                String op = Console.readLine(
                    "Введите знак операции (+,-,*,/)",
                    "[\\+\\-\\*/]"
                );

                array.apply(op, arg);

                Console.printLine();
                Console.printLine("Обработанный массив:");
                Console.printLine(array);

                Console.pause();
            }
        );

        mainMenu.addEntry(
            "B", "Запустить решение задачи B",
            () -> {
                Console.clear();

                ExtendedString string = new ExtendedString(
                    Console.readLine(
                        "Введите текст"
                    ).toLowerCase(Locale.ROOT)
                );
        
                Character vowels[] = {
                    'a', 'e', 'i', 'o', 'u', 'y',
                    'а', 'е', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'
                };
        
                Console.printLine(String.format(
                    "Количество гласных букв в тексте равно %d.",
                    string.countCharacters(vowels)
                ));

                Console.pause();
            }
        );

        mainMenu.addEntry(
            "C", "Запустить решение задачи C",
            () -> {
                Console.clear();

                Console.print("Введите текст: ");
                ExtendedString string = new ExtendedString(
                    Console.readLine()
                );

                Console.printLine(String.format(
                    "Текст с измененным порядком слов: %s",
                    string.reversedWordsOrder()
                ));

                Console.pause();
            }
        );

        mainMenu.run();
    }
}
