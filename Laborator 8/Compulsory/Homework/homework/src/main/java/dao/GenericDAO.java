package dao;

import database.Database;
import oopmodel.*;
import oopmodel.ModelClass;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T extends ModelClass> {
    private PreparedStatement createPStmt;
    private PreparedStatement getByIdPStmt;
    private PreparedStatement getByNamePStmt;
    private PreparedStatement getByNameTitlePStmt;
    private PreparedStatement findAllPStmt;

    public GenericDAO(String table) throws SQLException {
        Connection connection = Database.getConnection();
        switch (table) {
            case "genres" -> {
                createPStmt = connection.prepareStatement("insert into genres (name) values (?)");
                break;
            }
            case "artists" -> {
                createPStmt = connection.prepareStatement("insert into artists (name) values (?)");
                break;
            }
            default -> createPStmt = connection.prepareStatement("insert into albums ( release_year, title, artist, genre) values (?,?,?,?)");

        }
        getByIdPStmt = connection.prepareStatement(" select * from " + table + " where name= ?");
        getByNamePStmt = connection.prepareStatement("select * from " + table + " where name=?");
        getByNameTitlePStmt = connection.prepareStatement("select * from " + table + " where title=?");
        findAllPStmt = connection.prepareStatement("select * from "+ table);
    }
    public void create(T object, Class<T> cls) throws SQLException {
        if (object == null) {
            System.out.println("Cannot insert a null object!");
            return;
        }
        if (object instanceof Genre) {
            createPStmt.setString(1, object.getName());
            createPStmt.executeUpdate();
        } else if (object instanceof Artist) {
            createPStmt.setString(1, object.getName());
            createPStmt.executeUpdate();
        } else if (object instanceof Album) {
            createPStmt.setInt(1, ((Album) object).getRelease_year());
            createPStmt.setString(2, ((Album) object).getTitle());
            createPStmt.setString(3, ((Album) object).getArtist());
            createPStmt.setString(4,((Album) object).getGenre());

            int albumId;
            try (var rs = createPStmt.getGeneratedKeys()) {
                if (rs.next()) {
                    albumId = rs.getInt(1);
                } else {
                    throw new SQLException("Failed to retrieve auto-generated album ID.");
                }
            }
        }


        createPStmt.execute();
    }
    public T getById(int id, Class<T> cls) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        getByIdPStmt.setInt(1, id);
        ResultSet result = getByIdPStmt.executeQuery();

        T objectToReturn = cls.getDeclaredConstructor().newInstance();

        while (result.next()) {

            objectToReturn.setId(result.getInt(1));
            if (objectToReturn instanceof Album) {
                ((Album) objectToReturn).setRelease_year(result.getInt(2));
                ((Album) objectToReturn).setTitle(result.getString(3));
                ((Album) objectToReturn).setArtist(result.getString(4));
                ((Album) objectToReturn).setGenre(result.getString(5));
            }else {
                objectToReturn.setName(result.getString(2));
            }
        }
        return objectToReturn;
    }
    public T getByName(String name, Class<T> cls) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ResultSet result;
        T objectToReturn = cls.getDeclaredConstructor().newInstance();
        if (objectToReturn instanceof Album){
            getByNameTitlePStmt.setString(1,name);
            result=getByNameTitlePStmt.executeQuery();
        }
        else
        {
            getByNamePStmt.setString(1, name);
            result = getByNamePStmt.executeQuery();
        }
        while (result.next()) {
            objectToReturn.setId(result.getInt(1));
            if (objectToReturn instanceof Album) {
                ((Album) objectToReturn).setRelease_year(result.getInt(2));
                ((Album) objectToReturn).setTitle(result.getString(3));
                ((Album) objectToReturn).setArtist(result.getString(4));
                ((Album) objectToReturn).setGenre(result.getString(5));

            }else {
                objectToReturn.setName(result.getString(2));
            }
        }
        return objectToReturn;
    }
    public List<T> findAll(Class<T> cls) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<T> objectsToReturn = new ArrayList<>();
        ResultSet result = findAllPStmt.executeQuery();

        while (result.next()) {
            T object = cls.getDeclaredConstructor().newInstance();
            object.setId(result.getInt(1));
            if (object instanceof Album) {
                ((Album) object).setRelease_year(result.getInt(2));
                ((Album) object).setTitle(result.getString(3));
                ((Album) object).setArtist(result.getString(4));
                ((Album) object).setGenre(result.getString(5));
            } else {
                object.setName(result.getString(2));
            }
            objectsToReturn.add(object);
        }

        return objectsToReturn;
    }

}
