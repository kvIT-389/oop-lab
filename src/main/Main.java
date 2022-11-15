import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import ext.ExtendedString;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args)
    {
        String choice;
        do {
            ClearConsole();
            PrintMenu();

            choice = scanner.nextLine().toLowerCase(Locale.ROOT);

            ClearConsole();
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

            Pause();
        }
        while (!choice.equals("q"));

        ClearConsole();
    }

    private static void ClearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void Pause()
    {
        System.out.println("\nНажмите Enter, чтобы продолжить");
        scanner.nextLine();
    }

    private static void PrintMenu()
    {
        System.out.println("Выберите дальнейшее действие:");
        System.out.println("[A] - Запустить решение задачи A;");
        System.out.println("[B] - Запустить решение задачи B;");
        System.out.println("[C] - Запустить решение задачи C;");
        System.out.println("[Q] - Выйти из программы.");
        System.out.println();
        System.out.print("Ваш выбор: ");
    }


    private static void RunTaskA()
    {
        Integer size;
        do {
            System.out.print("\033[1A\r\033[J");
            System.out.print("Введите размер массива N (1 < N < 10): ");

            size = scanner.nextInt();
        }
        while (size <= 1 || size >= 10);

        ArrayList<Double> source_array = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            Double new_el = Math.round(
                (rand.nextDouble() * 100.0 - 50.0) * 10.0
            ) / 10.0;

            source_array.add(new_el);
        }

        System.out.println("Сгенерированный массив:");
        System.out.println(source_array);


        System.out.print("\nВведите второй операнд: ");
        Double arg = scanner.nextDouble();

        System.out.println("\n\n");

        String op_string;
        do {
            System.out.print("\033[1A\r\033[J");
            System.out.print("Введите знак операции (+,-,*,/): ");

            op_string = scanner.nextLine();
        }
        while (!op_string.matches("[\\+\\-\\*/]"));
        Character op = op_string.charAt(0);


        ArrayList<Double> new_array = new ArrayList<>();

        for (Double el : source_array) {
            Double new_el = 0.0;
            switch (op) {
                case '+':
                    new_el = el + arg;
                    break;

                case '-':
                    new_el = el - arg;
                    break;

                case '*':
                    new_el = el * arg;
                    break;

                case '/':
                    new_el = el / arg;
                    break;

            }
            new_array.add(new_el);
        }

        System.out.println("\nОбработанный массив:");
        System.out.println(new_array);
    }

    private static void RunTaskB()
    {
        System.out.print("Введите текст: ");
        ExtendedString string = new ExtendedString(
            scanner.nextLine().toLowerCase(Locale.ROOT)
        );

        Character vowels[] = {
            'a', 'e', 'i', 'o', 'u', 'y',
            'а', 'е', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'
        };

        System.out.println(String.format(
            "Количество гласных букв в тексте равно %d.",
            string.countCharacters(vowels)
        ));
    }

    private static void RunTaskC()
    {
        System.out.print("Введите текст: ");
        ExtendedString string = new ExtendedString(scanner.nextLine());

        System.out.println(String.format(
            "Текст с измененным порядком слов: %s",
            string.reversedWordsOrder()
        ));
    }
}
