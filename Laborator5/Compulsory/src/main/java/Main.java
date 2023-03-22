import documentsManagementSystem.*;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Book("article1","Titlu_de_articol","D:/Simona/cursuri Anul 3 sem 2/JAVA/Laboratoare/Laboratorul 5/Compulsory/catalog.json");
        var article = new Article("book1","Titlu_de_carte", "D:/Simona/cursuri Anul 3 sem 2/JAVA/Laboratoare/Laboratorul 5/Compulsory/catalog.json" );
        catalog.add(book);
        catalog.add(article);
        CatalogUtil.save(catalog, "D:/Simona/cursuri Anul 3 sem 2/JAVA/Laboratoare/Laboratorul 5/Compulsory/catalog.json");


    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("D:/Simona/cursuri Anul 3 sem 2/JAVA/Laboratoare/Laboratorul 5/Compulsory/catalog.json");
            CatalogUtil.view(catalog.findById("article1"));
            System.out.println(catalog);
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
