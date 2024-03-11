package commnads;

import com.fasterxml.jackson.databind.ObjectMapper;
import documentsManagementSystem.*;


import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command{
    public LoadCommand(Catalog catalog) {
        super(catalog);
        command = "load path";
    }

    @Override
    public void execute(String arg) throws CommandException, IOException {
        parseArguments(arg);
        if (arguments.size() == 1) {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(new File(arguments.get(0)), Catalog.class);
        } else {
            throw new CommandException("Invalid numbers of arguments on command " + command);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

