package commnads;

public class CommandException extends Exception {
    String message;
    public CommandException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
