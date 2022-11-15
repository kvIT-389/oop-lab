package con;

import java.util.Scanner;


public class Console {
    private static Scanner m_scannerSystemIn = new Scanner(System.in);

    private static String m_integerRegex = "[\\+\\-]?\\d+";
    private static String m_doubleRegex = "[\\+\\-]?\\d+(.\\d+)?";

    public Console() {}

    public static void clear()
    {
        System.out.flush();
        System.out.print("\033[H\033[2J");
    }

    public static void pause()
    {
        printLine();
        printLine("Нажмите Enter, чтобы продолжить");
        nextLine();
    }


    public static void print(Object obj)
    {
        System.out.print(obj);
    }

    public static void printLine()
    {
        System.out.print('\n');
    }

    public static void printLine(Object obj)
    {
        System.out.println(obj);
    }


    public static String nextLine()
    {
        return m_scannerSystemIn.nextLine();
    }

    public static String nextLine(String askMessage)
    {
        if (askMessage != null) {
            print(askMessage + ": ");
        }

        return nextLine();
    }

    public static String nextLine(String askMessage, String matchRegex)
    {
        String result = Console.nextLine(askMessage);

        while (!result.matches(matchRegex)) {
            print("\033[1A\r\033[K");

            result = Console.nextLine(askMessage);
        }

        return result;
    }


    public static Integer getInteger()
    {
        return Integer.parseInt(nextLine(
            null, m_integerRegex
        ));
    }

    public static Integer getInteger(String askMessage)
    {
        return Integer.parseInt(nextLine(
            askMessage, m_integerRegex
        ));
    }

    public static Integer getInteger(
        String askMessage,
        Integer leftBoundary, Integer rightBoundary
    )
    {
        Integer result = Console.getInteger(askMessage);
        while (result < leftBoundary || result > rightBoundary) {
            print("\033[1A\r\033[K");
            result = Console.getInteger(askMessage);
        }

        return result;
    }


    public static Double getDouble()
    {
        return Double.parseDouble(nextLine(
            null, m_doubleRegex
        ));
    }

    public static Double getDouble(String askMessage)
    {
        return Double.parseDouble(nextLine(
            askMessage, m_doubleRegex
        ));
    }

    public static Double getDouble(
        String askMessage,
        Double leftBoundary, Double rightBoundary
    )
    {
        Double result = Console.getDouble(askMessage);
        while (result < leftBoundary || result > rightBoundary) {
            print("\033[1A\r\033[K");
            result = Console.getDouble(askMessage);
        }

        return result;
    }
}
