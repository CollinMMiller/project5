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
        for (int i = 0; i < songs.size(); i++)
        {
            Song song = songs.get(i);
            for (int j = 0; j < 4; j++)
            {
                song.setHeard(j, 0);
                song.setLiked(j, 0);
                song.setTotalPeople(j, 0);
            }
            for (Student stu : students)
            {
                if (stu.getMajor() == null)
                {
                    continue;
                }
                String[] answers = stu.getAnswers();
                int answerIndex = i * 2;
                if (answers[answerIndex].equals(" "))
                {
                    continue;
                }
                
                song.incrementTotalPeople(stu.getMajor().ordinal());
                if (answers[answerIndex].equals("Yes"))
                {
                    song.incrementHeard(stu.getMajor().ordinal());
                }
                if (answers[answerIndex + 1].equals("Yes"))
                {
                    song.incrementLiked(stu.getMajor().ordinal());
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
        for (int i = 0; i < songs.size(); i++)
        {
            Song song = songs.get(i);
            for (int j = 0; j < 4; j++)
            {
                song.setHeard(j, 0);
                song.setLiked(j, 0);
                song.setTotalPeople(j, 0);
            }
            for (Student stu : students)
            {
                if (stu.getRegion() == null)
                {
                    continue;
                }
                String[] answers = stu.getAnswers();
                int answerIndex = i * 2;
                if (answers[answerIndex].equals(" "))
                {
                    continue;
                }
                
                song.incrementTotalPeople(stu.getRegion().ordinal());
                if (answers[answerIndex].equals("Yes"))
                {
                    song.incrementHeard(stu.getRegion().ordinal());
                }
                if (answers[answerIndex + 1].equals("Yes"))
                {
                    song.incrementLiked(stu.getRegion().ordinal());
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
        for (int i = 0; i < songs.size(); i++)
        {
            Song song = songs.get(i);
            for (int j = 0; j < 4; j++)
            {
                song.setHeard(j, 0);
                song.setLiked(j, 0);
                song.setTotalPeople(j, 0);
            }
            for (Student stu : students)
            {
                if (stu.getHobby() == null)
                {
                    continue;
                }
                String[] answers = stu.getAnswers();
                int answerIndex = i * 2;
                if (answers[answerIndex].equals(" "))
                {
                    continue;
                }
                
                song.incrementTotalPeople(stu.getHobby().ordinal());
                if (answers[answerIndex].equals("Yes"))
                {
                    song.incrementHeard(stu.getHobby().ordinal());
                }
                if (answers[answerIndex + 1].equals("Yes"))
                {
                    song.incrementLiked(stu.getHobby().ordinal());
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
