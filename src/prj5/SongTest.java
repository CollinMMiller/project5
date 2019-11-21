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
    private Song miseryBusiness;


    /**
     * Sets up the song
     */
    public void setUp()
    {
        miseryBusiness = new Song("Misery Business", "Paramore", 2007,
            "Alternative");
    }


    /**
     * Tests getTitle()
     */
    public void testGetTitle()
    {
        assertEquals("Misery Business", miseryBusiness.getTitle());
    }


    /**
     * Tests getArtist()
     */
    public void testGetArtist()
    {
        assertEquals("Paramore", miseryBusiness.getArtist());
    }


    /**
     * Tests getYear()
     */
    public void testGetYear()
    {
        assertEquals(2007, miseryBusiness.getYear());
    }


    /**
     * Tests getGenre()
     */
    public void testGetGenre()
    {
        assertEquals("Alternative", miseryBusiness.getGenre());
    }


    /**
     * Tests setLiked() and getLiked()
     */
    public void testGetLiked()
    {
        miseryBusiness.setLiked(0, 10);
        assertEquals(10, miseryBusiness.getLiked()[0]);
        miseryBusiness.setLiked(1, 10);
        assertEquals(10, miseryBusiness.getLiked()[1]);
        miseryBusiness.setLiked(2, 10);
        assertEquals(10, miseryBusiness.getLiked()[2]);
        miseryBusiness.setLiked(3, 10);
        assertEquals(10, miseryBusiness.getLiked()[3]);
    }


    /**
     * Tests setHeard() and getHeard()
     */
    public void testGetHeard()
    {
        miseryBusiness.setHeard(0, 10);
        assertEquals(10, miseryBusiness.getHeard()[0]);
        miseryBusiness.setHeard(1, 10);
        assertEquals(10, miseryBusiness.getHeard()[1]);
        miseryBusiness.setHeard(2, 10);
        assertEquals(10, miseryBusiness.getHeard()[2]);
        miseryBusiness.setHeard(3, 10);
        assertEquals(10, miseryBusiness.getHeard()[3]);
    }


    /**
     * Tests incrementHeard and incrementLiked methods
     */
    public void testIncrementMethods()
    {
        assertEquals(0, miseryBusiness.getHeard()[0]);
        miseryBusiness.incrementHeard(0);
        assertEquals(1, miseryBusiness.getHeard()[0]);

        assertEquals(0, miseryBusiness.getLiked()[0]);
        miseryBusiness.incrementLiked(0);
        assertEquals(1, miseryBusiness.getLiked()[0]);
    }

}
