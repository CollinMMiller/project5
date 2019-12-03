package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Creates the window to display information
 * @author Callie Louderback (calliel)
 * @version 2019.11.18
 *
 */
public class GUIWindow {

    /**
     * Which page the window is on
     */
    private int page;
    /**
     * List of songs
     */
    private LinkedList<Song> songs;
    /**
     * Database of the Students songs
     */
    private SongStudentDataBase database;
    /**
     * Window to display it in
     */
    private Window window;
    /**
     * The next button
     */
    private Button next;
    /**
     * The previous button
     */
    private Button previous;
    /**
     * Displays the legend title
     */
    private TextShape legend;
    
    private DataTypeEnum currentData = DataTypeEnum.HOBBY;
    
    /**
     * Creates a window with the given database
     * @param db Database of student songs
     */
    public GUIWindow(SongStudentDataBase db)
    {
        database = db;
        this.songs = db.getSongsByHobby();
        window = new Window();
        window.setTitle("Project 5: calliel, collinm2, zoez");
        Button hobby = new Button("Represent Hobby");
        window.addButton(hobby, WindowSide.SOUTH);
        hobby.onClick(this, "representHobby");
        Button major = new Button("Represent Major");
        window.addButton(major, WindowSide.SOUTH);
        major.onClick(this, "representMajor");
        Button region = new Button("Represent Region");
        window.addButton(region, WindowSide.SOUTH);
        region.onClick(this, "representRegion");
        Button quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "buttonQuit");
        previous = new Button("\u2190 Prev");
        window.addButton(previous, WindowSide.NORTH);
        previous.onClick(this, "buttonPrev");
        Button artist = new Button("Sort by Artist Name");
        window.addButton(artist, WindowSide.NORTH);
        artist.onClick(this, "sortByArtistName");
        Button title = new Button("Sort by Song Title");
        window.addButton(title, WindowSide.NORTH);
        title.onClick(this, "sortBySongTitle");
        Button year = new Button("Sort by Release Year");
        window.addButton(year, WindowSide.NORTH);
        year.onClick(this, "sortByReleaseYear");
        Button genre = new Button ("Sort by Genre");
        window.addButton(genre, WindowSide.NORTH);
        genre.onClick(this, "sortByGenre");
        next = new Button("Next \u2192");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "buttonNext");
        previous.disable();
        
    }
    
    /**
     * Turns to the previous page
     * @param button Button when clicked
     */
    public void buttonPrev(Button button)
    {
        next.enable();
        page--;
        if (page == 0)
        {
            previous.disable();
        }
        displayPage();
    }
    
    /**
     * Sorts by the artist's name
     * @param button Button when clicked
     */
    public void sortByArtistName(Button button)
    {
        this.songs.sortByArtist();
        displayPage();
    }
    
    /**
     * Sorts by the song's title
     * @param button
     */
    public void sortBySongTitle(Button button)
    {
        this.songs.sortByTitle();
        displayPage();
    }
    
    /**
     * Sorts by the song's release year
     * @param button Button when clicked
     */
    public void sortByReleaseYear(Button button)
    {
        this.songs.sortByYear();
        displayPage();
    }
    
    /**
     * Sorts by the song's genre
     * @param button Button when clicked
     */
    public void sortByGenre(Button button)
    {
        this.songs.sortByGenre();
        displayPage();
    }

    /**
     * Turns to the next page
     * @param button Button when clicked
     */
    public void buttonNext(Button button)
    {
        previous.enable();
        page++;
        if (page == Math.ceil(songs.size() / 9))
        {
            next.disable();
        }
        displayPage();
    }
    
    /**
     * 
     * @param songOnPage
     */
    public void displayPage()
    {
        window.removeAllShapes();
        //calls gui glyph
        if (Math.ceil(songs.size() / 9) < 2)
        {
            next.disable();
        }
        GUIGlyph display = new GUIGlyph(window);
        display.displayGlyphs(page, songs);
        
        switch (currentData)
        {
            case HOBBY:
                hobbyLegend();
                break;
            case MAJOR:
                majorLegend();
                break;
            case REGION:
                regionLegend();
                break;
            default:
                break;
        }
    }
    
    /**
     * Closes the window
     * @param button Button when clicked
     */
    public void buttonQuit(Button button)
    {
        System.exit(0);
    }
    
    /**
     * 
     * @param button Button when clicked
     */
    public void representHobby(Button button)
    {
        this.currentData = DataTypeEnum.HOBBY;
        songs = database.getSongsByHobby();
        displayPage();
    }
    
    /**
     * Display hobby legend
     */
    private void hobbyLegend()
    {
        Color transparent = new Color(0, 0, 0, 0);
        Shape divide = new Shape (660, 225, 5, 20);
        divide.setBackgroundColor(Color.BLACK);
        divide.setForegroundColor(Color.BLACK);
        window.addShape(divide);
        Shape legendBox = new Shape(610, 90, 100, 175);
        window.addShape(legendBox);
        legendBox.setBackgroundColor(Color.WHITE);
        legendBox.setForegroundColor(Color.BLACK);
        TextShape titleText = new TextShape(625, 200, "Song Title");
        titleText.setBackgroundColor(transparent);
        window.addShape(titleText);
        window.moveToFront(titleText);
        TextShape likedText = new TextShape(670, 225, "Likes");
        window.addShape(likedText);
        window.moveToFront(likedText);
        likedText.setBackgroundColor(transparent);
        TextShape heardText = new TextShape(615, 225, "Heard");
        window.addShape(heardText);
        window.moveToFront(heardText);
        heardText.setBackgroundColor(transparent);
        legend = new TextShape(612, 90, "Hobby Legend", 
            Color.BLACK);
        legend.setBackgroundColor(transparent);
        window.addShape(legend);
        window.moveToFront(legend);
        //read arts sport music
        TextShape read = new TextShape(640, 120, "Read", Color.PINK);
        window.addShape(read);
        read.setBackgroundColor(transparent);
        window.moveToFront(read);
        TextShape arts = new TextShape(643, 140, "Art", Color.BLUE);
        window.addShape(arts);
        arts.setBackgroundColor(transparent);
        window.moveToFront(arts);
        TextShape sports = new TextShape(640, 160, "Sports", Color.YELLOW);
        window.addShape(sports);
        sports.setBackgroundColor(transparent);
        window.moveToFront(sports);
        TextShape music = new TextShape(640, 180, "Music", Color.GREEN);
        window.addShape(music);
        music.setBackgroundColor(transparent);
        window.moveToFront(music);
    }
    
    /**
     * Display major legend
     */
    private void majorLegend()
    {
        Color transparent = new Color(0, 0, 0, 0);
        Shape divide = new Shape (660, 225, 5, 20);
        divide.setBackgroundColor(Color.BLACK);
        divide.setForegroundColor(Color.BLACK);
        window.addShape(divide);
        Shape legendBox = new Shape(610, 90, 100, 175);
        window.addShape(legendBox);
        legendBox.setBackgroundColor(Color.WHITE);
        legendBox.setForegroundColor(Color.BLACK);
        TextShape titleText = new TextShape(625, 200, "Song Title");
        titleText.setBackgroundColor(transparent);
        window.addShape(titleText);
        window.moveToFront(titleText);
        TextShape likedText = new TextShape(670, 225, "Likes");
        window.addShape(likedText);
        window.moveToFront(likedText);
        likedText.setBackgroundColor(transparent);
        TextShape heardText = new TextShape(615, 225, "Heard");
        window.addShape(heardText);
        window.moveToFront(heardText);
        heardText.setBackgroundColor(transparent);
        legend = new TextShape(613, 90, "Major Legend", 
            Color.BLACK);
        legend.setBackgroundColor(transparent);
        window.addShape(legend);
        window.moveToFront(legend);
        TextShape compS = new TextShape(630, 120, "Comp Sci", Color.PINK);
        window.addShape(compS);
        compS.setBackgroundColor(transparent);
        window.moveToFront(compS);
        TextShape eng = new TextShape(630, 140, "Other Eng", Color.BLUE);
        window.addShape(eng);
        eng.setBackgroundColor(transparent);
        window.moveToFront(eng);
        TextShape math = new TextShape(625, 160, "Math/CMDA", Color.YELLOW);
        window.addShape(math);
        math.setBackgroundColor(transparent);
        window.moveToFront(math);
        TextShape other = new TextShape(640, 180, "Other", Color.GREEN);
        window.addShape(other);
        other.setBackgroundColor(transparent);
        window.moveToFront(other);
    }
    
    /**
     * Display region legend
     */
    public void regionLegend()
    {
        Color transparent = new Color(0, 0, 0, 0);
        Shape divide = new Shape (660, 225, 5, 20);
        divide.setBackgroundColor(Color.BLACK);
        divide.setForegroundColor(Color.BLACK);
        window.addShape(divide);
        Shape legendBox = new Shape(610, 90, 100, 175);
        window.addShape(legendBox);
        legendBox.setBackgroundColor(Color.WHITE);
        legendBox.setForegroundColor(Color.BLACK);
        TextShape titleText = new TextShape(625, 200, "Song Title");
        titleText.setBackgroundColor(transparent);
        window.addShape(titleText);
        window.moveToFront(titleText);
        TextShape likedText = new TextShape(670, 225, "Likes");
        window.addShape(likedText);
        window.moveToFront(likedText);
        likedText.setBackgroundColor(transparent);
        TextShape heardText = new TextShape(615, 225, "Heard");
        window.addShape(heardText);
        window.moveToFront(heardText);
        heardText.setBackgroundColor(transparent);
        legend = new TextShape(610, 90, "Region Legend", 
            Color.BLACK);
        legend.setBackgroundColor(transparent);
        window.addShape(legend);
        window.moveToFront(legend);
        TextShape southE = new TextShape(630, 120, "Southeast", Color.PINK);
        window.addShape(southE);
        southE.setBackgroundColor(transparent);
        window.moveToFront(southE);
        TextShape northE = new TextShape(643, 140, "Northeast", Color.BLUE);
        window.addShape(northE);
        northE.setBackgroundColor(transparent);
        window.moveToFront(northE);
        TextShape other = new TextShape(640, 160, "US(other)", Color.YELLOW);
        window.addShape(other);
        other.setBackgroundColor(transparent);
        window.moveToFront(other);
        TextShape non = new TextShape(640, 180, "non-US", Color.GREEN);
        window.addShape(non);
        non.setBackgroundColor(transparent);
        window.moveToFront(non);
    }
    
    /**
     * 
     * @param button Button when clicked
     */
    public void representMajor(Button button)
    {
        this.currentData = DataTypeEnum.MAJOR;
        songs = database.getSongsByMajor();
        displayPage();
    }
    
    /**
     * 
     * @param button Button when clicked
     */
    public void representRegion(Button button)
    {
        this.currentData = DataTypeEnum.REGION;
        songs = database.getSongsByRegion();
        displayPage();
    }
}
