package prj5;

import student.TestCase;

/**
 * StudentTest class
 *
 * @author <Zoe Zheng> <zoez>
 * @version <11/17/2019>
 */
public class StudentTest extends TestCase {

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
    public void setUp() {
        h.add(new Song("t", "a", 2015, "G"));
        l.add(new Song("t", "a", 2015, "G"));
        s = new Student(m, r, hobby, h, l);

    }
    /**
     * getRegion test
     */
    public void testGetRegion(){
        assertEquals(r, s.getRegion());
        
    }
    /**
     * getHobby test
     */
    public void testGetHobby(){
        assertEquals(hobby, s.getHobby());
        
    }
    /**
     * getMajor test
     */
    public void testGetMajor(){
        assertEquals(m, s.getMajor());
    }
    
}
