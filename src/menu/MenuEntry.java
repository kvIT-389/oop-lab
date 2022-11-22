package menu;

import function.Action;


public class MenuEntry {
    private String m_title;
    private Action m_action;

    public MenuEntry(String title, Action action) {
        m_title = title;
        m_action = action;
    }

    public String toString() {
        return m_title;
    }

    public void run() {
        m_action.run();
    }
}
