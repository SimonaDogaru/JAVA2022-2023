import documentsManagementSystem.*;
import commnads.*;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, CommandException {
        Catalog catalog = new Catalog("MyDocuments");

        System.out.println("Comanda add:");
        AddCommand addCommand = new AddCommand(catalog);
        addCommand.execute("book book1 Titlu_de_carte1 D:/Simona/catalog.json");
        addCommand.execute("book book2 Titlu_de_carte2 D:/Simona/catalog.json");
        addCommand.execute("article acticol Titlu_de_articol D:/Simona/catalog.json");

        System.out.println(catalog);

        //save command class
        System.out.println("Comanda save:");
        SaveCommand saveCommand = new SaveCommand(catalog);
        saveCommand.execute("D:/Simona/catalog.json");
        //load command class
        System.out.println("Comanda load:");
        LoadCommand loadCommand = new LoadCommand(catalog);
        loadCommand.execute("D:/Simona/catalog.json");
        System.out.println(loadCommand);
        //list command class
        System.out.println("Comanda list:");
        ListCommand listCommand = new ListCommand(catalog);
        listCommand.execute("");
        //view command class
        System.out.println("Comanda view:");
        ViewCommand viewCommand = new ViewCommand(catalog);
        viewCommand.execute("book1");
    }


}
