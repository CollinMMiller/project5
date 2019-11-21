package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * reader class
 *
 * @author <Zoe Zheng> <zoez>, Collin Miller (collinm2)
 * @version <11/17/2019>
 */
public class FileReader
{

    private String songTitlesPath;
    private String surveyPath;
    private LinkedList<Song> songList;
    private LinkedList<Student> studentSurvey;


    /**
     * constructor
     * 
     * @throws FileNotFoundException
     */
    public FileReader(String surveyPath, String songPath)
        throws FileNotFoundException
    {
        this.songTitlesPath = songPath;
        this.surveyPath = surveyPath;
        songList = readSongTitles();
        studentSurvey = readSurvey();

    }


    /**
     * Returns major as enum
     * 
     * @param major
     *            major as String
     * @return major as enum
     */
    private MajorEnum getMajor(String major)
    {
        switch (major)
        {
            case "Computer Science":
                return MajorEnum.COMP_SCI;
            case "Math or CMDA":
                return MajorEnum.MATH_CMDA;
            case "Other Engineering":
                return MajorEnum.OTHER_ENG;
            case "Other":
                return MajorEnum.OTHER;
            default:
                return null;
        }
    }


    /**
     * Returns region as enum
     * 
     * @param region
     *            region as String
     * @return region as enum
     */
    private RegionEnum getRegion(String region)
    {
        switch (region)
        {
            case "Northeast":
                return RegionEnum.NORTHEAST;
            case "Southeast":
                return RegionEnum.SOUTHEAST;
            case "United States (other than Southeast or Northwest)":
                return RegionEnum.OTHER_US;
            case "Outside of United States":
                return RegionEnum.NOT_US;
            default:
                return null;
        }
    }


    private HobbyEnum getHobby(String hobby)
    {
        switch (hobby)
        {
            case "reading":
                return HobbyEnum.READ;
            case "art":
                return HobbyEnum.ART;
            case "sports":
                return HobbyEnum.SPORTS;
            case "music":
                return HobbyEnum.MUSIC;
            default:
                return null;
        }
    }

    /**
     * Reads the survey file
     * @return LinkedList of students
     * @throws FileNotFoundException If file is not found
     */
    private LinkedList<Student> readSurvey() throws FileNotFoundException
    {
        LinkedList<Student> students = new LinkedList<Student>();
        Scanner scanner = new Scanner(new File(surveyPath));
        scanner.nextLine(); // Skips the first line

        while (scanner.hasNextLine())
        {
            String[] tokens = scanner.nextLine().split(",");

            //Math to get the length of the string array
            //NOTE: / 2 * 2  is necessary
            int length = tokens.length / 2 * 2 - 4;
            
            String[] answers = new String[length];
            answers[length - 1] = ""; //if last column off data

            for (int i = 5; i < tokens.length; i++)
            {
                answers[i - 5] = tokens[i];
            }
            
            Student student = new Student(getMajor(tokens[2]), getRegion(
                tokens[3]), getHobby(tokens[4]), answers);
            students.add(student);
        }
        scanner.close();
        return students;
    }


    /**
     * readSongTitles
     * @return LinkedList<Song>
     * @throws FileNotFoundException when file is not found
     */
    private LinkedList<Song> readSongTitles() throws FileNotFoundException
    {
        songList = new LinkedList<Song>();
        File newFile = new File(songTitlesPath);
        Scanner file = new Scanner(newFile);
        file.nextLine();
        while (file.hasNextLine())
        {
            String line = file.nextLine();
            String[] tokens = line.split(",");

            String title = tokens[0].trim();
            String artist = tokens[1].trim();
            int year = Integer.valueOf(tokens[2].trim());
            String genre = tokens[3].trim();

            songList.add(new Song(title, artist, year, genre));
        }
        file.close();

        return songList;
    }

    /**
     * Returns a database containing the songs and students
     * @return a database containing the songs and students
     */
    public SongStudentDataBase createDatabase()
    {
        SongStudentDataBase db = 
            new SongStudentDataBase(songList, studentSurvey);
        LinkedList<Song> songs = db.getSongsByHobby();
        songs.sortByGenre();
        for (Song song : songs)
        {
            printSongData(song);
        }

        songs.sortByTitle();
        for (Song song : songs)
        {
            printSongData(song);
        }
        return db;
    }
    
    private void printSongData(Song song)
    {
        System.out.println("Song Title: " + song.getTitle());
        System.out.println("Song Artist: " + song.getArtist());
        System.out.println("Song Genre: " + song.getGenre());
        System.out.println("Song Year: " + song.getYear());
        System.out.println("Heard");
        
        int[] totals = song.getTotalPeople();
        for (int i = 0; i < 4; i++)
        {
            totals[i] = totals[i] == 0 ? 1 : totals[i];
        }
        
        int[] heard = song.getHeard();
        System.out.println("reading:" + heard[0] * 100 / totals[0] +
            " art:" + heard[1] * 100 / totals[1] +
            " sports:" + heard[2] * 100 / totals[2] +
            " music:" + heard[3] * 100 / totals[3]);
        
        System.out.println("Likes");
        int[] likes = song.getLiked();
        System.out.println("reading:" + likes[0] * 100 / totals[0] +
            " art:" + likes[1] * 100 / totals[1] +
            " sports:" + likes[2] * 100 / totals[2] +
            " music:" + likes[3] * 100 / totals[3]);
        System.out.println();
    }
}
