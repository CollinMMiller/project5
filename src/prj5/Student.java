package prj5;

/**
 * Student class
 *
 * @author <Zoe Zheng> <zoez>
 * @version <11/17/2019>
 */
public class Student {

    private MajorEnum major;
    private RegionEnum region;
    private HobbyEnum hobby;
    private LinkedList<Song> liked;
    private LinkedList<Song> heard;


    /**
     * read
     * 
     * @param major
     *            student's major
     * @param region
     *            student's region
     * @param hobby
     *            student's hobby
     * @param heard
     *            heard list
     * @param liked
     *            liked list
     */
    public Student(
        MajorEnum major,
        RegionEnum region,
        HobbyEnum hobby,
        private LinkedList<Song> heard,
        private LinkedList<Song> liked) {

        this.major = major;
        this.region = region;
        this.hobby = hobby;
        this.liked = liked;
        this.heard = heard;

    }

    /**
     * getMajor
     * @return MajorEnum
     */
    public MajorEnum getMajor()
    {
        return major;

    }
    /**
     * getRegion
     * @return RegionEnum
     */
    public RegionEnum getRegion()
    {
        return region;
    }
    /**
     * getHobby
     * @return HobbyEnum
     */
    public HobbyEnum getHobby()
    {
        return hobby;
    }
}
