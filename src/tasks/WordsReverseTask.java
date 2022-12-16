package tasks;

import con.Console;
import ext.ExtendedString;
import function.Action;


public class WordsReverseTask implements Action {
    public void run() {
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
