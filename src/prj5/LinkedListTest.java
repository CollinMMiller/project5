package prj5;

import java.util.Iterator;
import student.TestCase;

/**
 * Tests the LinkedList class
 * 
 * @author Callie Louderback(calliel)
 * @version 2019.11.17
 */
public class LinkedListTest extends TestCase
{

    /**
     * LinkedList to test with
     */
    LinkedList<String> test;


    /**
     * Sets up the test LinkedList
     */
    public void setUp()
    {
        test = new LinkedList<String>();
    }


    /**
     * Tests the size() method
     */
    public void testSize()
    {
        assertEquals(0, test.size());
        test.add("Test");
        assertEquals(1, test.size());
        test.add("Test1");
        Exception e = null;
        try
        {
            test.add(null);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertNotNull(e);
        assertEquals(2, test.size());
    }


    /**
     * Tests isEmpty()
     */
    public void testIsEmpty()
    {
        assertTrue(test.isEmpty());
        test.add("Test");
        assertFalse(test.isEmpty());
    }


    /**
     * Tests remove()
     */
    public void testRemove()
    {
        Exception e = null;
        try
        {
            test.remove(1);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertNotNull(e);
        test.add("A");
        e = null;
        try
        {
            test.remove(-1);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertNotNull(e);
        assertEquals("A", test.remove(0));
        test.add("A");
        test.add("B");
        test.add("C");
        assertEquals("C", test.remove(2));
        e = null;
        try
        {
            test.remove(3);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertNotNull(e);
    }


    /**
     * Tests get()
     */
    public void testGet()
    {
        Exception e = null;
        try
        {
            test.get(1);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertNotNull(e);
        test.add("A");
        test.add("B");
        assertEquals("B", test.get(1));
    }


    /**
     * Tests contains()
     */
    public void testContains()
    {
        assertFalse(test.contains("B"));
        test.add("A");
        assertFalse(test.contains("B"));
        assertTrue(test.contains("A"));
        test.clear();
        assertFalse(test.contains("A"));
    }


    /**
     * Tests lastIndexOf()
     */
    public void testLastIndexOf()
    {
        assertEquals(-1, test.lastIndexOf("A"));
        test.add("B");
        test.add("B");
        test.add("C");
        assertEquals(1, test.lastIndexOf("B"));
    }


    /**
     * Tests toString()
     */
    public void testToString()
    {
        assertEquals("[]", test.toString());

        test.add("A");
        test.add("B");
        test.add("C");
        assertEquals("[A, B, C]", test.toString());
    }


    // implements comparable
    /**
     * Tests the Iterator
     */
    public void testIterator()
    {
        Iterator<String> testIterator = test.iterator();
        assertFalse(testIterator.hasNext());
        Exception e = null;
        try
        {
            testIterator.next();
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertNotNull(e);
        test.add("A");
        test.add("B");
        testIterator = test.iterator();
        assertTrue(testIterator.hasNext());
        assertEquals("A", testIterator.next());
        e = null;
        try
        {
            testIterator.remove();
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertNotNull(e);
    }


    public void testAddInsert()
    {
        test.add("test");
        test.add(0, "test2");
        assertEquals("test2", test.get(0));
        test.add(1, "Test3");
        assertEquals("Test3", test.get(1));
        test.add(3, "last");
        assertEquals("last", test.get(3));

        Exception e = null;
        try
        {
            test.add(-1, "test");
        }
        catch (Exception x)
        {
            e = x;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);

        e = null;
        try
        {
            test.add(12, "test");
        }
        catch (Exception x)
        {
            e = x;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests sortByArtist
     */
    public void testSortByArtist()
    {
        test.sortByArtist();
        test.add("Hey");
        test.add("Woah");

        Exception e = null;

        try
        {
            test.sortByArtist();
        }
        catch (Exception x)
        {
            e = x;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);

        Song song1 = new Song("", "B", 0, "");
        Song song2 = new Song("", "D", 0, "");
        Song song3 = new Song("", "a", 0, "");
        Song song4 = new Song("", "t", 0, "");
        Song song5 = new Song("", "K", 0, "");
        LinkedList<Song> songs = new LinkedList<Song>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);

        songs.sortByArtist();

        assertEquals(song3, songs.get(0));
        assertEquals(song1, songs.get(1));
        assertEquals(song2, songs.get(2));
        assertEquals(song5, songs.get(3));
        assertEquals(song4, songs.get(4));
    }


    /**
     * Test Sort by Title
     */
    public void testSortByTitle()
    {
        test.sortByTitle();
        test.add("Hey");
        test.add("Woah");

        Exception e = null;

        try
        {
            test.sortByTitle();
        }
        catch (Exception x)
        {
            e = x;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);

        Song song1 = new Song("B", "", 0, "");
        Song song2 = new Song("D", "", 0, "");
        Song song3 = new Song("a", "", 0, "");
        Song song4 = new Song("t", "", 0, "");
        Song song5 = new Song("K", "", 0, "");
        LinkedList<Song> songs = new LinkedList<Song>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);

        songs.sortByTitle();

        assertEquals(song3, songs.get(0));
        assertEquals(song1, songs.get(1));
        assertEquals(song2, songs.get(2));
        assertEquals(song5, songs.get(3));
        assertEquals(song4, songs.get(4));
    }


    /**
     * Test sort by year
     */
    public void testSortByYear()
    {
        test.sortByYear();
        test.add("Hey");
        test.add("Woah");

        Exception e = null;

        try
        {
            test.sortByYear();
        }
        catch (Exception x)
        {
            e = x;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);

        Song song1 = new Song("", "", 10, "");
        Song song2 = new Song("", "", 20, "");
        Song song3 = new Song("", "", 0, "");
        Song song4 = new Song("", "", 400, "");
        Song song5 = new Song("", "", 30, "");
        LinkedList<Song> songs = new LinkedList<Song>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);

        songs.sortByYear();

        assertEquals(song3, songs.get(0));
        assertEquals(song1, songs.get(1));
        assertEquals(song2, songs.get(2));
        assertEquals(song5, songs.get(3));
        assertEquals(song4, songs.get(4));
    }


    /**
     * Test sort by genre
     */
    public void testSortByGenre()
    {
        test.sortByGenre();
        test.add("Hey");
        test.add("Woah");

        Exception e = null;

        try
        {
            test.sortByGenre();
        }
        catch (Exception x)
        {
            e = x;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);

        Song song1 = new Song("", "", 0, "g");
        Song song2 = new Song("", "", 0, "Z");
        Song song3 = new Song("", "", 0, "y");
        Song song4 = new Song("", "", 0, "l");
        Song song5 = new Song("", "", 0, "b");
        LinkedList<Song> songs = new LinkedList<Song>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);

        songs.sortByGenre();

        assertEquals(song2, songs.get(0));
        assertEquals(song5, songs.get(1));
        assertEquals(song1, songs.get(2));
        assertEquals(song4, songs.get(3));
        assertEquals(song3, songs.get(4));
    }
}
