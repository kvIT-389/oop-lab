package tasks;

import con.Console;
import ext.ExtendedString;
import function.Action;


public class VowelsCountTask implements Action {
    public void run() {
        ExtendedString string = new ExtendedString(
            Console.readLine(
                "Введите текст"
            ).toLowerCase()
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
}
