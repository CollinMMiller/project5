package prj5;

import student.TestCase;

public class SongStudentDataBaseTest extends TestCase
{
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private Song song5;
    private Song song6;

    private Student stu1;
    private Student stu2;

    private SongStudentDataBase db;


    /**
     * Runs before each test
     */
    public void setUp()
    {
        song1 = new Song("song1", "", 0, "");
        song2 = new Song("song2", "", 0, "");
        song3 = new Song("song3", "", 0, "");
        song4 = new Song("song4", "", 0, "");
        song5 = new Song("song5", "", 0, "");
        song6 = new Song("song6", "", 0, "");

        LinkedList<Song> list1 = new LinkedList<Song>();
        list1.add(song1);
        list1.add(song2);
        list1.add(song3);

        LinkedList<Song> list2 = new LinkedList<Song>();
        list2.add(song1);
        list2.add(song2);

        stu1 = new Student(MajorEnum.COMP_SCI, RegionEnum.NORTHEAST,
            HobbyEnum.READ, list1, list2);

        LinkedList<Song> list3 = new LinkedList<Song>();
        list3.add(song1);
        list3.add(song2);
        list3.add(song3);
        list3.add(song4);
        list3.add(song5);
        list3.add(song6);

        LinkedList<Song> list4 = new LinkedList<Song>();
        list4.add(song4);
        list4.add(song6);

        stu2 = new Student(MajorEnum.OTHER, RegionEnum.NOT_US, HobbyEnum.MUSIC,
            list3, list4);

        LinkedList<Song> songs = new LinkedList<Song>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);

        LinkedList<Student> students = new LinkedList<Student>();
        students.add(stu1);
        students.add(stu2);

        db = new SongStudentDataBase(songs, students);
    }


    /**
     * Tests getSongsByMajor
     */
    public void testGetSongsByMajor()
    {
        LinkedList<Song> songs = db.getSongsByMajor();
        songs = db.getSongsByMajor();
        assertEquals(1, songs.get(0).getHeard()[0]);
        assertEquals(0, songs.get(0).getHeard()[1]);
        assertEquals(0, songs.get(0).getHeard()[2]);
        assertEquals(1, songs.get(0).getHeard()[3]);

        assertEquals(1, songs.get(0).getLiked()[0]);
        assertEquals(0, songs.get(0).getLiked()[1]);
        assertEquals(0, songs.get(0).getLiked()[2]);
        assertEquals(0, songs.get(0).getLiked()[3]);

        assertEquals(0, songs.get(3).getHeard()[0]);
        assertEquals(0, songs.get(3).getHeard()[1]);
        assertEquals(0, songs.get(3).getHeard()[2]);
        assertEquals(1, songs.get(3).getHeard()[3]);

        assertEquals(0, songs.get(3).getLiked()[0]);
        assertEquals(0, songs.get(3).getLiked()[1]);
        assertEquals(0, songs.get(3).getLiked()[2]);
        assertEquals(1, songs.get(3).getLiked()[3]);
    }


    /**
     * Tests getSongsByRegion
     */
    public void testGetSongsByRegion()
    {
        LinkedList<Song> songs = db.getSongsByRegion();
        songs = db.getSongsByRegion();
        assertEquals(1, songs.get(0).getHeard()[0]);
        assertEquals(0, songs.get(0).getHeard()[1]);
        assertEquals(0, songs.get(0).getHeard()[2]);
        assertEquals(1, songs.get(0).getHeard()[3]);

        assertEquals(1, songs.get(0).getLiked()[0]);
        assertEquals(0, songs.get(0).getLiked()[1]);
        assertEquals(0, songs.get(0).getLiked()[2]);
        assertEquals(0, songs.get(0).getLiked()[3]);

        assertEquals(0, songs.get(3).getHeard()[0]);
        assertEquals(0, songs.get(3).getHeard()[1]);
        assertEquals(0, songs.get(3).getHeard()[2]);
        assertEquals(1, songs.get(3).getHeard()[3]);

        assertEquals(0, songs.get(3).getLiked()[0]);
        assertEquals(0, songs.get(3).getLiked()[1]);
        assertEquals(0, songs.get(3).getLiked()[2]);
        assertEquals(1, songs.get(3).getLiked()[3]);
    }


    /**
     * Tests getSongsByHobby
     */
    public void testGetSongsByHobby()
    {
        LinkedList<Song> songs = db.getSongsByHobby();
        songs = db.getSongsByHobby();
        assertEquals(1, songs.get(0).getHeard()[0]);
        assertEquals(0, songs.get(0).getHeard()[1]);
        assertEquals(0, songs.get(0).getHeard()[2]);
        assertEquals(1, songs.get(0).getHeard()[3]);

        assertEquals(1, songs.get(0).getLiked()[0]);
        assertEquals(0, songs.get(0).getLiked()[1]);
        assertEquals(0, songs.get(0).getLiked()[2]);
        assertEquals(0, songs.get(0).getLiked()[3]);

        assertEquals(0, songs.get(3).getHeard()[0]);
        assertEquals(0, songs.get(3).getHeard()[1]);
        assertEquals(0, songs.get(3).getHeard()[2]);
        assertEquals(1, songs.get(3).getHeard()[3]);

        assertEquals(0, songs.get(3).getLiked()[0]);
        assertEquals(0, songs.get(3).getLiked()[1]);
        assertEquals(0, songs.get(3).getLiked()[2]);
        assertEquals(1, songs.get(3).getLiked()[3]);
    }


    /**
     * Test getStudents
     */
    public void testGetStudents()
    {
        assertEquals(stu1, db.getStudents().get(0));
        assertEquals(stu2, db.getStudents().get(1));
    }
}
