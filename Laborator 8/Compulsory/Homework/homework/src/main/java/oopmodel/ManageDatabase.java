package oopmodel;
import dao.GenericDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class ManageDatabase {
    private GenericDAO<Artist> artistGenericDAO;
    private GenericDAO<Genre> genreGenericDAO;
    private GenericDAO<Album> albumGenericDAO;

    public ManageDatabase() {
        try {
            artistGenericDAO = new GenericDAO<>("artists");
            genreGenericDAO = new GenericDAO<>("genres");
            albumGenericDAO = new GenericDAO<>("albums");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GenericDAO<Artist> getArtistGenericDAO() {
        return artistGenericDAO;
    }

    public void setArtistGenericDAO(GenericDAO<Artist> artistGenericDAO) {
        this.artistGenericDAO = artistGenericDAO;
    }

    public GenericDAO<Genre> getGenreGenericDAO() {
        return genreGenericDAO;
    }

    public void setGenreGenericDAO(GenericDAO<Genre> genreGenericDAO) {
        this.genreGenericDAO = genreGenericDAO;
    }

    public GenericDAO<Album> getAlbumGenericDAO() {
        return albumGenericDAO;
    }

    public void setAlbumGenericDAO(GenericDAO<Album> albumGenericDAO) {
        this.albumGenericDAO = albumGenericDAO;
    }

    @Override
    public String toString() {
        return "ManageDatabase{" +
                "artistGenericDAO=" + artistGenericDAO +
                ", genreGenericDAO=" + genreGenericDAO +
                ", albumGenericDAO=" + albumGenericDAO +
                '}';
    }

    public Artist getArtistById(int id) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return artistGenericDAO.getById(id, Artist.class);
    }

    public Genre getGenreById(int id) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return genreGenericDAO.getById(id, Genre.class);
    }

    public Album getAlbumById(int id) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       return albumGenericDAO.getById(id, Album.class);
    }
    public Genre getGenreByName(String name) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       return genreGenericDAO.getByName(name, Genre.class);
    }
    public Album getAlbumByName(String name) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return albumGenericDAO.getByName(name, Album.class);
    }
    public Artist getArtistByName(String name) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return artistGenericDAO.getByName(name, Artist.class);
    }
    public void addGenre(Genre add) throws SQLException{
        genreGenericDAO.create(add,Genre.class);
    }
    public void addArtist(Artist add) throws SQLException{
        artistGenericDAO.create(add,Artist.class);
    }
    public void addAlbum(Album add) throws SQLException{
        albumGenericDAO.create(add,Album.class);
    }
    public List findAllGenre() throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       return genreGenericDAO.findAll(Genre.class);
    }
    public List findAllArtists() throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return artistGenericDAO.findAll(Artist.class);
    }
    public List findAllAlbums() throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//
        return albumGenericDAO.findAll(Album.class);

    }

}
