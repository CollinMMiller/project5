package prj5;

import student.TestCase;

/**
 * StudentTest class
 *
 * @author <Zoe Zheng> <zoez>
 * @version <11/17/2019>
 */
public class StudentTest extends TestCase
{

    private Student s;
    private LinkedList<Song> h;
    private LinkedList<Song> l;
    private MajorEnum m;
    private RegionEnum r;
    private HobbyEnum hobby;
    // private Song song;


    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp()
    {
        h.add(new Song("t", "a", 2015, "G"));
        l.add(new Song("t", "a", 2015, "G"));
        s = new Student(m, r, hobby, h, l);

    }


    /**
     * getRegion test
     */
<<<<<<< HEAD
    public void testGetRegion()
    {
=======
    public void testGetRegion(){
>>>>>>> 593cdb1aa7871d2d5da83adfc7bb80f6c8ede34d
        assertEquals(r, s.getRegion());

    }


    /**
     * getHobby test
     */
<<<<<<< HEAD
    public void testGetHobby()
    {
=======
    public void testGetHobby(){
>>>>>>> 593cdb1aa7871d2d5da83adfc7bb80f6c8ede34d
        assertEquals(hobby, s.getHobby());

    }


    /**
     * getMajor test
     */
<<<<<<< HEAD
    public void testGetMajor()
    {
=======
    public void testGetMajor(){
>>>>>>> 593cdb1aa7871d2d5da83adfc7bb80f6c8ede34d
        assertEquals(m, s.getMajor());
    }

}
