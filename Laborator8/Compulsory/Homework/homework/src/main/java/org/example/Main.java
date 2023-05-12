package org.example;

import oopmodel.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ManageDatabase databaseManager = new ManageDatabase();
 //      List listAlbums = databaseManager.findAllAlbums();

//        for (Object elem:listAlbums) {
//            System.out.println(listAlbums);
//        }
    //    System.out.println(databaseManager.findAllArtists());

//        databaseManager.findAllGenre();

        databaseManager.addArtist(new Artist(22,"artist"));
        System.out.println( databaseManager.getArtistById(22));

    }
}