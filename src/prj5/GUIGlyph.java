package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * Displays glyphs
 * 
 * @author Callie Louderback (Calliel), Collin Miller (collinm2)
 * @version 2019.11.18
 */
public class GUIGlyph {
    
    private Shape[] dataShapes = new Shape[72];
    
    private TextShape[] songTitleText = new TextShape[9];
    
    private TextShape[] songArtistText = new TextShape[9];
    
    private Window window;
    
    public GUIGlyph(Window window)
    {
        this.window = window;
        for (int i = 0; i < 9; i++)
        {
            int xCenter = i % 3 * 200 + 90;
            int yCenter = i / 3 * 90 + 12;
            
            Shape bar = new Shape(xCenter, yCenter + 33, 5, 40, Color.BLACK);
            window.addShape(bar);
            
            songTitleText[i] = new TextShape(xCenter, yCenter, "");
            songTitleText[i].setBackgroundColor(Color.WHITE);
            window.addShape(songTitleText[i]);
            window.moveToBack(songTitleText[i]);
            
            songArtistText[i] = new TextShape(xCenter, yCenter + 15, "");
            songArtistText[i].setBackgroundColor(Color.WHITE);
            window.addShape(songArtistText[i]);
            window.moveToBack(songArtistText[i]);
        }
        
        for (int i = 0; i < 72; i++)
        {
            //Empty shape
            dataShapes[i] = new Shape(0, 0, 0, 0);
            window.addShape(dataShapes[i]);
        }
    }
    
    public void displayGlyphs(int page, LinkedList<Song> songs)
    {
        for (int i = 0; i < 9; i++)
        {
            if (page * 9 + i < songs.size())
            {
                int xCenter = i % 3 * 200 + 90;
                int yCenter = i / 3 * 90 + 12;
                Song song = songs.get(page * 9 + i);
                if (song.getTitle().equals("Hotline Bling"))
                    System.out.println("Test");
                window.removeShape(songTitleText[i]);
                songTitleText[i].setText(song.getTitle());
                songTitleText[i].setX(xCenter -
                    (song.getTitle().length() / 2 * 7) - 2);
                window.addShape(songTitleText[i]);
                
                window.removeShape(songArtistText[i]);
                songArtistText[i].setText("By " + song.getArtist());
                songArtistText[i].setX(xCenter -
                    (song.getArtist().length() / 2 * 7) - 15);
                window.addShape(songArtistText[i]);
                
                for(int j = 0; j < 8; j++)
                {
                    window.removeShape(dataShapes[i * 8 + j]);
                }
                
                int heard[] = song.getHeard();
                int liked[] = song.getLiked();
                int totals[] = song.getTotalPeople();
                for (int j = 0; j < 4; j++)
                {
                    totals[j] = totals[j] == 0 ? 1 : totals[j];
                }
                int maxWidth = 50;
                int height = 10;
                Color[] colors = { Color.PINK, Color.BLUE,
                    Color.YELLOW, Color.GREEN };
                
                for (int j = 0; j < 4; j++)
                {
                    //Heard
                    double tmpWidth = maxWidth * 
                        (double) heard[j] / (double) totals[j];
                    dataShapes[i * 8 + j] = new Shape(xCenter - (int)tmpWidth,
                        yCenter + 33 + j * 10, (int) tmpWidth,
                        height, colors[j]);
                    //Liked
                    tmpWidth = maxWidth * 
                        (double) liked[j] / (double) totals[j];
                    dataShapes[i * 8 + 4 + j] = new Shape(xCenter + 5, 
                        yCenter + 33 + j * 10, (int) tmpWidth,
                        height, colors[j]);
                }
                
                for(int j = 0; j < 8; j++)
                {
                    window.addShape(dataShapes[i * 8 + j]);
                }
                
    //            TextShape title = new TextShape(15 * (i + 1), 15,
    //                songs.get(i).getTitle());
    //            title.setBackgroundColor(Color.WHITE);
    //            songTitleText[i] = title;
    //            TextShape artist = new TextShape(15 * (i + 1),
    //                30, "by " + songs.get(i).getArtist());
    //            artist.setBackgroundColor(Color.WHITE);
    //            songArtistText[i] = artist;
    //            window.addShape(artist);
    //            window.addShape(title);
    //            window.addShape(new Shape(15, 50, 10, 50, Color.BLACK));
    //            window.addShape(new Shape(15, 45, 60, 10, Color.PINK));
    //            window.addShape(new Shape(15, 60, 60, 10, Color.BLUE));
    //            window.addShape(new Shape(15, 75, 60, 10, Color.YELLOW));
    //            window.addShape(new Shape(15, 90, 60, 10, Color.GREEN));
            }
        }
        
    }
}
