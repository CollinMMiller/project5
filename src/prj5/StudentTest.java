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
    private MajorEnum m;
    private RegionEnum r;
    private HobbyEnum hobby;
    // private Song song;


    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp()
    {
        String[] info = {"Hi", "Hi2"};
        s = new Student(m, r, hobby, info);

    }


    /**
     * getRegion test
     */
    public void testGetRegion()
    {
        assertEquals(r, s.getRegion());
    }


    /**
     * getHobby test
     */
    public void testGetHobby()
    {
        assertEquals(hobby, s.getHobby());

    }


    /**
     * getMajor test
     */
    public void testGetMajor()
    {
        assertEquals(m, s.getMajor());
    }

    /**
     * Tests geAnswers
     */
    public void testGetAnswers()
    {
        assertEquals("Hi", s.getAnswers()[0]);
    }
}
