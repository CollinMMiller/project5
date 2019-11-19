package prj5;

import student.TestCase;

/**
 * Tests the Song class
 * 
 * @author Callie Louderback (calliel)(
 * @version 2019.11.17
 */
public class SongTest extends TestCase
{

    /**
     * Creates a new song
     */
    private Song misery_Business;


    /**
     * Sets up the song
     */
    public void setUp()
    {
        misery_Business = new Song("Misery Business", "Paramore", 2007,
            "Alternative");
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
        misery_Business.setLiked(0, 10);
        assertEquals(10, misery_Business.getLiked()[0]);
        misery_Business.setLiked(1, 10);
        assertEquals(10, misery_Business.getLiked()[1]);
        misery_Business.setLiked(2, 10);
        assertEquals(10, misery_Business.getLiked()[2]);
        misery_Business.setLiked(3, 10);
        assertEquals(10, misery_Business.getLiked()[3]);
    }


    /**
     * Tests setHeard() and getHeard()
     */
    public void testGetHeard()
    {
        misery_Business.setHeard(0, 10);
        assertEquals(10, misery_Business.getHeard()[0]);
        misery_Business.setHeard(1, 10);
        assertEquals(10, misery_Business.getHeard()[1]);
        misery_Business.setHeard(2, 10);
        assertEquals(10, misery_Business.getHeard()[2]);
        misery_Business.setHeard(3, 10);
        assertEquals(10, misery_Business.getHeard()[3]);
    }


    /**
     * Tests incrementHeard and incrementLiked methods
     */
    public void testIncrementMethods()
    {
        assertEquals(0, misery_Business.getHeard()[0]);
        misery_Business.incrementHeard(0);
        assertEquals(1, misery_Business.getHeard()[0]);

        assertEquals(0, misery_Business.getLiked()[0]);
        misery_Business.incrementLiked(0);
        assertEquals(1, misery_Business.getLiked()[0]);
    }

}
