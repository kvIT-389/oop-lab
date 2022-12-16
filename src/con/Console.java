package con;

import io.StreamReader;
import io.StreamWriter;


public class Console {
    private static StreamReader m_consoleReader = new StreamReader(System.in);
    private static StreamWriter m_consoleWriter = new StreamWriter(System.out);

    private static final String m_integerRegex = "[\\+\\-]?\\d+";
    private static final String m_doubleRegex = "[\\+\\-]?\\d+(.\\d+)?";

    private static String m_pauseMessage = "Нажмите Enter, чтобы продолжить";

    public Console() {}

    public static void clear() {
        print("\033[H\033[2J");
    }

    public static void clearLastLine() {
        print("\033[1A\r\033[K");
    }

    public static void pause() {
        printLine();
        printLine(m_pauseMessage);
        readLine();
    }

    public static void print(Object obj) {
        m_consoleWriter.print(obj);
    }

    public static void printLine() {
        m_consoleWriter.printLine();
    }

    public static void printLine(Object obj) {
        m_consoleWriter.printLine(obj);
    }

    public static String readLine() {
        return m_consoleReader.readLine();
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
            clearLastLine();
            result = readLine(askMessage);
        }

        return result;
    }

    public static Integer readInteger() {
        return Integer.parseInt(readLine(
            null, m_integerRegex
        ));
    }

    public static Integer readInteger(String askMessage) {
        return Integer.parseInt(readLine(
            askMessage, m_integerRegex
        ));
    }

    public static Integer readInteger(String askMessage,
                                     Integer leftBoundary,
                                     Integer rightBoundary) {
        Integer result = readInteger(askMessage);

        while (result < leftBoundary || result > rightBoundary) {
            clearLastLine();
            result = readInteger(askMessage);
        }

        return result;
    }

    public static Double readDouble() {
        return Double.parseDouble(readLine(
            null, m_doubleRegex
        ));
    }

    public static Double readDouble(String askMessage) {
        return Double.parseDouble(readLine(
            askMessage, m_doubleRegex
        ));
    }

    public static Double readDouble(String askMessage,
                                    Double leftBoundary,
                                    Double rightBoundary) {
        Double result = readDouble(askMessage);

        while (result < leftBoundary || result > rightBoundary) {
            clearLastLine();
            result = readDouble(askMessage);
        }

        return result;
    }
}
