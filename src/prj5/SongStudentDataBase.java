package prj5;

/**
 * SongStudentDataBase class
 *
 * @author <Zoe Zheng> <zoez>
 * @version <11/17/2019>
 */
public class SongStudentDataBase {

    private LinkedList<Song> songs;
    private LinkedList<Student> students;


    /**
     * SongStudentDataBase()
     * 
     * @param songs
     *            a list of songs
     * @param students
     *            a list of students
     */
    public SongStudentDataBase(
        LinkedList<Song> songs,
        LinkedList<Student> students) {
        this.songs = songs;
        this.students = students;

    }


    /**
     * getSongsByMajor
     * liked songs and heard songs in each major
     * 
     * @param major
     *            student's major
     * @return LinkedList<Song>
     */
    public LinkedList<Song> getSongsByMajor(MajorEnum major) {

    }


    /**
     * getSongsByRegion
     * liked songs and heard songs in each region
     * 
     * @param region
     *            student's region
     * @return LinkedList<Song>
     */
    public LinkedList<Song> getSongsByRegion(RegionEnum region) {

    }


    /**
     * getSongsByHobby
     * liked songs and heard songs in each hobby
     * 
     * @param hobby
     *            student's hobby
     * @return LinkedList<Song>
     */
    public LinkedList<Song> getSongsByHobby(HobbyEnum hobby) {

    }


    /**
     * getStudents
     * 
     * @return LinkedList<Song>
     */
    public LinkedList<Student> getStudents() {

    }

}
