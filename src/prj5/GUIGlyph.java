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
    
    public void displayGlyphs(int page, Window window, List<Song> songs)
    {
        
    }
}
