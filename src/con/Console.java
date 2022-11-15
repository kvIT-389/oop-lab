package con;

import java.util.Scanner;


public class Console {
    private static Scanner m_scannerSystemIn = new Scanner(System.in);

    private static String m_integerRegex = "[\\+\\-]?\\d+";
    private static String m_doubleRegex = "[\\+\\-]?\\d+(.\\d+)?";

    public Console() {}

    public static void clear() {
        System.out.flush();
        System.out.print("\033[H\033[2J");
    }

    public static void pause() {
        printLine();
        printLine("Нажмите Enter, чтобы продолжить");
        readLine();
    }


    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void printLine() {
        System.out.print('\n');
    }

    public static void printLine(Object obj) {
        System.out.println(obj);
    }


    public static String readLine() {
        return m_scannerSystemIn.nextLine();
    }

    public static String readLine(String askMessage) {
        if (askMessage != null) {
            print(askMessage + ": ");
        }

        return readLine();
    }

    public static String readLine(String askMessage,
                                  String matchRegex) {
        String result = readLine(askMessage);

        while (!result.matches(matchRegex)) {
            print("\033[1A\r\033[K");
            result = readLine(askMessage);
        }

        return result;
    }


    public static Integer getInteger() {
        return Integer.parseInt(readLine(
            null, m_integerRegex
        ));
    }

    public static Integer getInteger(String askMessage) {
        return Integer.parseInt(readLine(
            askMessage, m_integerRegex
        ));
    }

    public static Integer getInteger(String askMessage,
                                     Integer leftBoundary,
                                     Integer rightBoundary) {
        Integer result = getInteger(askMessage);

        while (result < leftBoundary || result > rightBoundary) {
            print("\033[1A\r\033[K");
            result = getInteger(askMessage);
        }

        return result;
    }


    public static Double getDouble() {
        return Double.parseDouble(readLine(
            null, m_doubleRegex
        ));
    }

    public static Double getDouble(String askMessage) {
        return Double.parseDouble(readLine(
            askMessage, m_doubleRegex
        ));
    }

    public static Double getDouble(String askMessage,
                                   Double leftBoundary,
                                   Double rightBoundary) {
        Double result = getDouble(askMessage);
        while (result < leftBoundary || result > rightBoundary) {
            print("\033[1A\r\033[K");
            result = getDouble(askMessage);
        }

        return result;
    }
}
