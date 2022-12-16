package tasks;

import java.util.Random;

import con.Console;
import ext.ExtendedArray;
import function.Action;


public class ArrayApplyTask implements Action {
    public void run() {
        Integer size = Console.readInteger(
            "Введите размер массива N (2 <= N <= 10)", 2, 10
        );

        ExtendedArray array = new ExtendedArray();

        Random rand = new Random();
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
    }
}
