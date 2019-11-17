package prj5;

import student.TestCase;

/**
 * Tests the Song class
 * @author Callie Louderback (calliel)(
 * @version 2019.11.17
 */
public class SongTest extends TestCase {
    
    /**
     * Creates a new song
     */
    private Song misery_Business;
    
    /**
     * Sets up the song
     */
    public void setUp()
    {
        misery_Business = new Song("Misery Business", "Paramore",
            2007, "Alternative");
    }
    
    /**
     * Tests getTitle()
     */
    public void testGetTitle()
    {
        assertEquals("Misery Business", misery_Business.getTitle());
    }
    
    /**
     * Tests getArtist()
     */
    public void testGetArtist()
    {
        assertEquals("Paramore", misery_Business.getArtist());
    }
    
    /**
     * Tests getYear()
     */
    public void testGetYear()
    {
        assertEquals(2007, misery_Business.getYear());
    }
    
    /**
     * Tests getGenre()
     */
    public void testGetGenre()
    {
        assertEquals("Alternative", misery_Business.getGenre());
    }
    
    /**
     * Tests setLiked() and getLiked()
     */
    public void testGetLiked()
    {
        misery_Business.setLiked(2464000);
        assertEquals(2464000, misery_Business.getLiked());
    }
    
    /**
     * Tests setHeard() and getHeard()
     */
    public void testGetHeard()
    {
        misery_Business.setHeard(8030055);
        assertEquals(8030055, misery_Business.getHeard());
    }

}
