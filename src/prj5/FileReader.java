package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * reader class
 *
 * @author <Zoe Zheng> <zoez>
 * @version <11/17/2019>
 */
public class FileReader
{

    private String songTitlesPath;
    private String surveyPath;
    private LinkedList<Song> songList;
    private LinkedList<Student> studentSurvy;


    /**
     * constructor
     * 
     * @throws FileNotFoundException
     */
    public FileReader() throws FileNotFoundException
    {

        songList = readSongTitles();
        studentSurvy = readSurvey();

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


    private LinkedList<Student> readSurvey() throws FileNotFoundException
    {
        LinkedList<Student> students = new LinkedList<Student>();
        Scanner scanner = new Scanner(new File(surveyPath));
        scanner.nextLine(); // Skips the first line

        while (scanner.hasNextLine())
        {
            String[] tokens = scanner.nextLine().split(",");

            LinkedList<Song> heard = new LinkedList<Song>();
            LinkedList<Song> liked = new LinkedList<Song>();

            for (int i = 5; i < tokens.length; i++)
            {
                String response = tokens[i];
                int songNum = (i - 5) / 2;

                if (response.equals("Yes"))
                {
                    if (i % 2 == 1)
                    {
                        heard.add(songList.get(songNum));
                    }
                    else
                    {
                        liked.add(songList.get(songNum));
                    }
                }
            }
            Student student = new Student(getMajor(tokens[2]), getRegion(
                tokens[3]), getHobby(tokens[4]), heard, liked);
            studentSurvy.add(student);
        }
        scanner.close();
        return students;
    }


    /**
     * readSongTitles
     * 
     * @return LinkedList<Song>
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

}
