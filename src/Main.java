import java.util.Locale;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String choice;
        do {
            ClearConsole();

            System.out.println("Выберите дальнейшее действие:");
            System.out.println("[A] - Запустить решение задачи A;");
            System.out.println("[B] - Запустить решение задачи B;");
            System.out.println("[C] - Запустить решение задачи C;");
            System.out.println("[Q] - Выйти из программы.");
            System.out.println();
            System.out.print("Ваш выбор: ");

            choice = scanner.nextLine().toLowerCase(Locale.ROOT);

            ClearConsole();
            switch (choice) {
                case "a":
                    System.out.println("Решаем задачу A");
                    break;

                case "b":
                    System.out.println("Решаем задачу B");
                    break;

                case "c":
                    System.out.println("Решаем задачу C");
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
}
