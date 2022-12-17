import menu.Menu;
import menu.NoExitEntryException;
import tasks.ArrayApplyTask;
import tasks.VowelsCountTask;
import tasks.WordsReverseTask;


public class Main {
    public static void main(String[] args)
    {
        Menu mainMenu = new Menu(
            "Выберите действие:", "Q", "Выход"
        );

        mainMenu.addEntry(
            "A", "Запустить решение задачи A",
            new ArrayApplyTask()
        );

        mainMenu.addEntry(
            "B", "Запустить решение задачи B",
            new VowelsCountTask()
        );

        mainMenu.addEntry(
            "C", "Запустить решение задачи C",
            new WordsReverseTask()
        );

        try {
            mainMenu.run();
        }
        catch (NoExitEntryException e) {}
    }
}
