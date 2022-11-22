package menu;

import java.util.HashMap;
import java.util.ArrayList;

import con.Console;
import function.Action;


public class Menu {
    private HashMap<String, MenuEntry> m_entries;

    private ArrayList<String> m_entriesNames;
    private ArrayList<String> m_exitEntriesNames;

    private String m_choiceAskMessage;

    public Menu() {
        this("Q", "Выход");
    }

    public Menu(String exitEntryName, String exitEntryTitle) {
        m_entries = new HashMap<>();
        m_entriesNames = new ArrayList<>();
        m_exitEntriesNames = new ArrayList<>();

        m_choiceAskMessage = "Ваш выбор";

        addExitEntry(
            exitEntryName, exitEntryTitle,
            () -> { Console.clear(); }
        );
    }


    public void addEntry(String name, String title, Action action) {
        String upperCaseName = name.toUpperCase();
        MenuEntry entry = new MenuEntry(title, action);

        putEntry(upperCaseName, entry);
        m_entriesNames.add(upperCaseName);
    }

    public void addExitEntry(String name, String title, Action action) {
        String upperCaseName = name.toUpperCase();
        MenuEntry entry = new MenuEntry(title, action);
        
        putEntry(upperCaseName, entry);
        m_exitEntriesNames.add(upperCaseName);
    }

    private void putEntry(String upperCaseName, MenuEntry entry) {
        m_entries.put(upperCaseName, entry);
    }


    public void run() {
        while (true) {
            Console.clear();

            printEntries();
            Console.printLine();

            String choice = Console.readLine(m_choiceAskMessage).toUpperCase();
            Console.printLine();

            if (m_entries.containsKey(choice)) {
                m_entries.get(choice).run();
            }

            if (m_exitEntriesNames.contains(choice)) {
                break;
            }
        }
    }

    private void printEntries() {
        for (String name : m_entriesNames) {
            printEntry(name);
        }

        for (String name : m_exitEntriesNames) {
            printEntry(name);
        }
    }

    private void printEntry(String name) {
        Console.printLine(String.format(
            "[%s] %s;", name, m_entries.get(name)
        ));
    }
}
