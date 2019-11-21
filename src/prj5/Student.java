package prj5;

/**
 * Student class
 *
 * @author <Zoe Zheng> <zoez>
 * @version <11/17/2019>
 */
public class Student
{

    private MajorEnum major;
    private RegionEnum region;
    private HobbyEnum hobby;
    private String[] answers;


    /**
     * Student()
     * 
     * @param major
     *            student's major
     * @param region
     *            student's region
     * @param hobby
     *            student's hobby
     * @param answers
     *            answer array
     */
    public Student(
        MajorEnum major,
        RegionEnum region,
        HobbyEnum hobby,
        String[] answers)
    {

        this.major = major;
        this.region = region;
        this.hobby = hobby;
        this.answers = answers;
    }


    /**
     * getMajor
     * 
     * @return MajorEnum
     */
    public MajorEnum getMajor()
    {
        return major;

    }


    /**
     * getRegion
     * 
     * @return RegionEnum
     */
    public RegionEnum getRegion()
    {
        return region;
    }


    /**
     * getHobby
     * 
     * @return HobbyEnum
     */
    public HobbyEnum getHobby()
    {
        return hobby;
    }


    /**
     * Get answers array
     * @return  answers
     */
    public String[] getAnswers()
    {
        return answers;
    }
    
}
