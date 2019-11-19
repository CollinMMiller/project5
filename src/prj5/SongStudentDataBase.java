package prj5;

/**
 * SongStudentDataBase class
 *
 * @author <Zoe Zheng> <zoez>, Collin Miller (collinm2)
 * @version <11/17/2019>
 */
public class SongStudentDataBase
{

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
        LinkedList<Student> students)
    {
        this.songs = songs;
        this.students = students;
    }


    /**
     * getSongsByMajor
     * liked songs and heard songs in each major
     * 
     * @return LinkedList<Song>
     */
    public LinkedList<Song> getSongsByMajor()
    {
        for (Song song : songs)
        {
            for (int i = 0; i < 4; i++)
            {
                song.setHeard(i, 0);
                song.setLiked(i, 0);
            }
            for (Student stu : students)
            {
                if (stu.getMajor() == null)
                {
                    continue;
                }
                if (stu.getLiked().contains(song))
                {
                    song.incrementLiked(stu.getMajor().ordinal());
                }
                if (stu.getHeard().contains(song))
                {
                    song.incrementHeard(stu.getMajor().ordinal());
                }
            }
        }
        return songs;
    }


    /**
     * getSongsByRegion
     * liked songs and heard songs in each region
     * 
     * @return LinkedList<Song>
     */
    public LinkedList<Song> getSongsByRegion()
    {
        for (Song song : songs)
        {
            for (int i = 0; i < 4; i++)
            {
                song.setHeard(i, 0);
                song.setLiked(i, 0);
            }
            for (Student stu : students)
            {
                if (stu.getRegion() == null)
                {
                    continue;
                }
                if (stu.getLiked().contains(song))
                {
                    song.incrementLiked(stu.getRegion().ordinal());
                }
                if (stu.getHeard().contains(song))
                {
                    song.incrementHeard(stu.getRegion().ordinal());
                }
            }
        }
        return songs;
    }


    /**
     * getSongsByHobby
     * liked songs and heard songs in each hobby
     * 
     * @return LinkedList<Song>
     */
    public LinkedList<Song> getSongsByHobby()
    {
        for (Song song : songs)
        {
            for (int i = 0; i < 4; i++)
            {
                song.setHeard(i, 0);
                song.setLiked(i, 0);
            }
            for (Student stu : students)
            {
                if (stu.getHobby() == null)
                {
                    continue;
                }
                if (stu.getLiked().contains(song))
                {
                    song.incrementLiked(stu.getHobby().ordinal());
                }
                if (stu.getHeard().contains(song))
                {
                    song.incrementHeard(stu.getHobby().ordinal());
                }
            }
        }
        return songs;
    }


    /**
     * getStudents
     * 
     * @return LinkedList<Song>
     */
    public LinkedList<Student> getStudents()
    {
        return students;
    }

}
