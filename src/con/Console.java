package con;

import java.util.Scanner;


public class Console {
    private static Scanner m_scannerSystemIn = new Scanner(System.in);

    public Console() {}

    public static void clear()
    {
        System.out.flush();
        System.out.print("\033[H\033[2J");
    }

    public static void pause()
    {
        printLine("\nНажмите Enter, чтобы продолжить");
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

    public static Integer nextInteger()
    {
        return m_scannerSystemIn.nextInt();
    }

    public static Double nextDouble()
    {
        return m_scannerSystemIn.nextDouble();
    }
}
