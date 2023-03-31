package commnads;



import documentsManagementSystem.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command{
    public ViewCommand(Catalog catalog) {
        super(catalog);
        command = "view ";
    }

    @Override
    public void execute(String arg) throws CommandException, IOException {
        parseArguments(arg);
        if (arguments.size() == 1) {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            assert desktop != null;
            desktop.open(new File(catalog.findById(arguments.get(0)).getLocation()));
        } else {
            throw new CommandException("Invalid load call. Write " + command);
        }
    }
}
