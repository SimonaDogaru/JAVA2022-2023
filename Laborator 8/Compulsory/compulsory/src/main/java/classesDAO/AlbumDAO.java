package classesDAO;

import org.example.Database;

import java.sql.*;

public class AlbumDAO {
    public void create(int release_year, String title, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums ( release_year, title, artist, genre) values (?,?,?,?)")) {
            pstmt.setInt(1, release_year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from albums where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("select name from albums where id=' " + id + "'")) {
            ResultSet rs =  pstmt.executeQuery();
            return rs.next() ? rs.getString(1) : null;
        }
    }
    public void showAll() throws SQLException {
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM albums");
        while (rs.next()) {
            int id = rs.getInt("id");
            int releaseYear = rs.getInt("release_year");
            String title = rs.getString("title");
            String artist = rs.getString("artist");
            String genre = rs.getString("genre");
            System.out.println(id + "\t" + releaseYear + "\t" + title + "\t" + artist + "\t" + genre);
        }
        rs.close();
        stmt.close();
        con.close();

    }


}
