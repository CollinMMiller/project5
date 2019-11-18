package prj5;

/**
 * Implementation of a Song object
 * @author Callie Louderback (calliel)
 * @version 2019.11.17
 */
public class Song {

    /**
     * Title of the song
     */
    private String title;
    /**
     * Song's artist
     */
    private String artist;
    /**
     * Year the song was release
     */
    private int year;
    /**
     * The Songs genre
     */
    private String genre;
    /**
     * Number of people who have liked the song
     */
    private int[] numberOfLiked = new int[4];
    /**
     * Number of people who have heard the song
     */
    private int[] numberOfHeard = new int[4];
    
    /**
     * Creates a new Song
     * @param title Song title
     * @param artist Song artist
     * @param year Year released
     * @param genre Song genre
     */
    public Song(String title, String artist, int year, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }
    
    /**
     * Returns the title of the song
     * @return Song title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Returns the artist of the song
     * @return Song artist
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Returns the year the song was released
     * @return Release year
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * Returns the genre of the song
     * @return Song genre
     */
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * Sets the number of people who have liked the song
     * @param liked Amount of people who have liked the song
     */
    public void setLiked(int liked)
    {
        numberOfLiked = liked;
    }
    
    /**
     * Returns the number of people who have liked the song
     * @return Number of people who have liked the song
     */
    public int getLiked(int index, int liked)
    {
        
        return numberOfLiked;
    }
    
    /**
     * Sets the amount of people who have heard the song
     * @param heard The number of people who have heard the song
     */
    public void setHeard(int index, int heard)
    {
        numberOfHeard = heard;
    }
    
    /**
     * Returns the number of people who have heard the song
     * @return The number of people who have hard the song
     */
    public int getHeard()
    {
        return numberOfHeard;
    }
}
