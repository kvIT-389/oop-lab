package menu;


public class NoExitEntryException extends Exception {
    public NoExitEntryException() {}

    public NoExitEntryException(String message) {
        super(message);
    }
}
