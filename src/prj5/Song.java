package prj5;

/**
 * Implementation of a Song object
 * 
 * @author Callie Louderback (calliel)
 * @version 2019.11.17
 */
public class Song
{

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
    private int[] numberOfLiked;
    /**
     * Number of people who have heard the song
     */
    private int[] numberOfHeard;
    
    /**
     * Total people in each field of major,hobby, or region
     */
    private int[] totalPeopleInField;


    /**
     * Creates a new Song
     * 
     * @param title
     *            Song title
     * @param artist
     *            Song artist
     * @param year
     *            Year released
     * @param genre
     *            Song genre
     */
    public Song(String title, String artist, int year, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        numberOfLiked = new int[4];
        numberOfHeard = new int[4];
        totalPeopleInField = new int[4];
    }


    /**
     * Returns the title of the song
     * 
     * @return Song title
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * Returns the artist of the song
     * 
     * @return Song artist
     */
    public String getArtist()
    {
        return artist;
    }


    /**
     * Returns the year the song was released
     * 
     * @return Release year
     */
    public int getYear()
    {
        return year;
    }


    /**
     * Returns the genre of the song
     * 
     * @return Song genre
     */
    public String getGenre()
    {
        return genre;
    }


    /**
     * Sets the number of people who have liked the song
     * 
     * @param index which hobby/major/skill
     * @param liked
     *            Amount of people who have liked the song
     */
    public void setLiked(int index, int liked)
    {
        numberOfLiked[index] = liked;
    }


    /**
     * Returns the number of people who have liked the song
     * 
     * @return Number of people who have liked the song
     */
    public int[] getLiked()
    {

        return numberOfLiked;
    }


    /**
     * Sets the amount of people who have heard the song
     * @param index which hobby/major/skill
     * @param heard
     *            The number of people who have heard the song
     */
    public void setHeard(int index, int heard)
    {
        numberOfHeard[index] = heard;
    }


    /**
     * Returns the number of people who have heard the song
     * 
     * @return The number of people who have hard the song
     */
    public int[] getHeard()
    {
        return numberOfHeard;
    }


    /**
     * Increments a value of liked
     * 
     * @param index
     *            which major/region/hobby
     */
    public void incrementLiked(int index)
    {
        numberOfLiked[index]++;
    }


    /**
     * Increments a value of heard
     * 
     * @param index
     *            which major/region/hobby
     */
    public void incrementHeard(int index)
    {
        numberOfHeard[index]++;
    }
    
    /**
     * Sets total amount of people for an index
     * @param index index
     * @param value value to be set
     */
    public void setTotalPeople(int index, int value)
    {
        totalPeopleInField[index] = value;
    }
    
    /**
     * Increments a value at and index
     * @param index index
     */
    public void incrementTotalPeople(int index)
    {
        totalPeopleInField[index]++;
    }
    
    /**
     * Returns values at index
     * @return values at index
     */
    public int[] getTotalPeople()
    {
        return totalPeopleInField;
    }
}
