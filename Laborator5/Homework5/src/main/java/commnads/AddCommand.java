package commnads;


import documentsManagementSystem.*;

public class AddCommand extends Command{
    public AddCommand(Catalog catalog) {
        super(catalog);
        command = "add document";
    }
    @Override
    public void execute(String arg) throws CommandException {
        parseArguments(arg);
        if(arguments.size() == 4){
            if(arguments.get(0).equals("book")){
                Document addItem = new Document(arguments.get(1), arguments.get(2), arguments.get(3));
                catalog.add(addItem);
            }
            else if (arguments.get(0).equals("article")){
                Document addItem = new Document(arguments.get(1), arguments.get(2), arguments.get(3));
                catalog.add(addItem);
            }
            else {
                throw new CommandException("Invalid document type on command " + command);
            }

        }else {
            throw new CommandException("Invalid numbers of arguments on command " + command);
        }
        arguments.clear();

    }
}
