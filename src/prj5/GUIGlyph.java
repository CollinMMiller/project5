package prj5;

import java.util.List;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

public class GUIGlyph {

    private int studentsTotal;
    
    private Shape[] dataShapes = new Shape[72];
    
    private TextShape[] songTitleText = new TextShape[9];
    
    private TextShape[] songArtistText = new TextShape[9];
    
    public GUIGlyph(int totalStudents)
    {
        studentsTotal = totalStudents;
    }
    
    public void displayGlyphs(int page, Window window, LinkedList<Song> songs)
    {
        //System.out.println(songs.);
        for (int i = 0; i < songs.size(); i++)
        {
            System.out.println(i);
            System.out.println(songs.get(i).getTitle());
            TextShape title = new TextShape(15 * (i+1), 15, songs.get(i).getTitle());
            songTitleText[i] = title;
            TextShape artist = new TextShape(15 * (i+1), 30, "by " + 
            songs.get(i).getArtist());
            songArtistText[i] = artist;
            window.addShape(artist);
            window.addShape(title);
        }
        
    }
}
