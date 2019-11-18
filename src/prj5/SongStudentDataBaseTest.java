package prj5;

public class SongStudentDataBaseTest
{
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private Song song5;
    private Song song6;
    private Song song7;
    private Song song8;
    
    private Student stu1;
    private Student stu2;
    private Student stu3;
    private Student stu4;
    
    private SongStudentDataBase db;
    
    public void setUp()
    {
        song1 = new Song("", "", 0, "");
        song2 = new Song("", "", 0, "");
        song3 = new Song("", "", 0, "");
        song4 = new Song("", "", 0, "");
        song5 = new Song("", "", 0, "");
        song6 = new Song("", "", 0, "");
        song7 = new Song("", "", 0, "");
        song8 = new Song("", "", 0, "");
        
        
        stu1 = new Student(MajorEnum.COMP_SCI,
            RegionEnum.NORTHEAST, HobbyEnum.ART, heard, liked)
    }
}
