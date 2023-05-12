package oopmodel;

public class Album extends ModelClass{
    private int release_year;
    private String title;
    private String artist;
    private String genre;
    public Album(){
        super();

    }
    public Album(int id, String title, Integer release_year, String artist, String genre) {
        super(id, title);
        this.release_year= release_year;
        this.artist= artist;
        this.genre= genre;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Album{" +
                "release_year=" + release_year +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
