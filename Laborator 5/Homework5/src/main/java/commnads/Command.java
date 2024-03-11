package commnads;


import documentsManagementSystem.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public abstract class Command {
    String command;
    List<String> arguments;
    Catalog catalog;

    public Command(Catalog catalog) {
        this.catalog = catalog;
        arguments = new LinkedList<>();
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public abstract void execute(String arguments) throws CommandException, InvalidCatalogException, IOException;

    void parseArguments(String arg) {
        this.arguments.addAll(Arrays.asList(arg.split(" ")));
    }

    @Override
    public String toString() {
        return "Command{" + "call='" + command + '\'' + ", arguments=" + arguments + ", catalog=" + catalog + '}';
    }
}
