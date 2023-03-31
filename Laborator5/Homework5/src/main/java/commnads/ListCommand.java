package commnads;

import documentsManagementSystem.*;

public class ListCommand extends Command{
    public ListCommand(Catalog catalog) {
        super(catalog);
        command = "list";
    }

    @Override
    public void execute(String arg) throws CommandException {
        parseArguments(arg);
        if (arguments.size() == 1) {
            for (Document i : catalog.getDocuments()) {
                System.out.println(i);
            }
        } else {
            throw new CommandException("Invalid numbers of arguments on command " + command);
        }
    }
}
