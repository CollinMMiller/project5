package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * Displays glyphs
 * 
 * @author Callie Louderback (Calliel)
 * @version 2019.11.18
 */
public class GUIGlyph {

//    private int studentsTotal;
    
    //private Shape[] dataShapes = new Shape[72];
    
    private TextShape[] songTitleText = new TextShape[9];
    
    private TextShape[] songArtistText = new TextShape[9];
    
    public GUIGlyph(int totalStudents)
    {
//        studentsTotal = totalStudents;
    }
    
    public void displayGlyphs(int page, Window window, LinkedList<Song> songs)
    {
        for (int i = 0; i < songs.size(); i++)
        {
            TextShape title = new TextShape(15 * (i + 1), 15,
                songs.get(i).getTitle());
            title.setBackgroundColor(Color.WHITE);
            songTitleText[i] = title;
            TextShape artist = new TextShape(15 * (i + 1),
                30, "by " + songs.get(i).getArtist());
            artist.setBackgroundColor(Color.WHITE);
            songArtistText[i] = artist;
            window.addShape(artist);
            window.addShape(title);
            window.addShape(new Shape(15, 50, 10, 50, Color.BLACK));
            window.addShape(new Shape(15, 45, 60, 10, Color.PINK));
            window.addShape(new Shape(15, 60, 60, 10, Color.BLUE));
            window.addShape(new Shape(15, 75, 60, 10, Color.YELLOW));
            window.addShape(new Shape(15, 90, 60, 10, Color.GREEN));
        }
        
    }
}
