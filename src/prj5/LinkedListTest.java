package prj5;

import java.util.Iterator;
import student.TestCase;

/**
 * Tests the LinkedList class
 * @author Callie Louderback(calliel)
 * @version 2019.11.17
 */
public class LinkedListTest extends TestCase{

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
        assertEquals(1, test.lastIndexOf("B"));
    }
    
    /**
     * Tests toString()
     */
    public void testToString()
    {
        test.add("A");
        test.add("B");
        test.add("C");
        assertEquals("{A, B, C}", test.toString());
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
}
