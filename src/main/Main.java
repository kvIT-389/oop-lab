import java.util.Locale;
import java.util.Random;

import con.Console;
import ext.ExtendedArray;
import ext.ExtendedString;


public class Main {
    private static Random rand = new Random();

    public static void main(String[] args)
    {
        String choice;
        do {
            Console.clear();
            PrintMenu();

            choice = Console.readLine(
                "Ваш выбор"
            ).toLowerCase(Locale.ROOT);

            Console.clear();
            switch (choice) {
                case "a":
                    RunTaskA();
                    break;

                case "b":
                    RunTaskB();
                    break;

                case "c":
                    RunTaskC();
                    break;

                default:
                    continue;
            }

            Console.pause();
        }
        while (!choice.equals("q"));

        Console.clear();
    }

    private static void PrintMenu()
    {
        Console.printLine("Выберите дальнейшее действие:");
        Console.printLine("[A] - Запустить решение задачи A;");
        Console.printLine("[B] - Запустить решение задачи B;");
        Console.printLine("[C] - Запустить решение задачи C;");
        Console.printLine("[Q] - Выйти из программы.");
        Console.printLine();
    }


    private static void RunTaskA()
    {
        Integer size = Console.getInteger(
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

        Double arg = Console.getDouble("Введите второй операнд");
        String op = Console.readLine(
            "Введите знак операции (+,-,*,/)",
            "[\\+\\-\\*/]"
        );

        array.apply(op, arg);

        Console.printLine();
        Console.printLine("Обработанный массив:");
        Console.printLine(array);
    }

    private static void RunTaskB()
    {
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
    }

    private static void RunTaskC()
    {
        Console.print("Введите текст: ");
        ExtendedString string = new ExtendedString(
            Console.readLine()
        );

        Console.printLine(String.format(
            "Текст с измененным порядком слов: %s",
            string.reversedWordsOrder()
        ));
    }
}
