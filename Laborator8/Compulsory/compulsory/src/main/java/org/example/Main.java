package org.example;
import classesDAO.*;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock"); //TODO: Funk, Soul, Pop
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.getConnection().commit();
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            System.out.println("The Id of the album with title The Wall is " + albums.findByName("The Wall"));
            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
            Database.getConnection().commit();
//            //TODO: print all the albums in the database
            albums.showAll();
             Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}