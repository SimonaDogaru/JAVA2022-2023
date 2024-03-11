package commnads;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import documentsManagementSystem.*;


import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command{
    public SaveCommand(Catalog catalog) {
        super(catalog);
        command = "save path";
    }

    @Override
    public void execute(String arg) throws CommandException, IOException {
        parseArguments(arg);
        if (arguments.size() == 1) {
            ObjectMapper objectMapper = new ObjectMapper();
           // objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(arguments.get(0)), catalog);
        } else {
            throw new CommandException("Invalid numbers of arguments on command " + command);
        }
    }
}
