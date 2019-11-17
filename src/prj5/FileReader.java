package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * reader class
 *
 * @author <Zoe Zheng> <zoez>
 * @version <11/17/2019>
 */
public class FileReader {

    private String SongTitlesPath;
    private String surveyPath;
    private LinkedList<Song> SongList;
    private LinkedList<Student> StudentSurvy;


    public FileReader() throws FileNotFoundException {
        SongList = readSongTitles();
        StudentSurvy = readSurvey();

    }


    private LinkedList<Student> readSurvey() {
        StudentSurvy = new LinkedList<Student>();
        File newFile = new File(surveyPath);
        Scanner file = new Scanner(newFile);
        // not read the first line
        String s = file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();

            String[] tokens = line.split(",");
            // if no 72 comma

            String heard[] = new String[34];// hold 67 survey questions
            String liked[] = new String[34];
            // if anwser is blank, make it to no
            for (int i = 5; i <= 72; i++) {
                if ((i % 2) == 1) {
                    // heard

                    for (int j = 0; j < 34; j++) {
                        String a = "No";
                        if (String.valueOf(tokens[i].trim()) != "Yes") {
                            // make it to No
                            a = tokens[i].trim();

                        }
                        heard[j] = String.valueOf(tokens[i].trim());
                    }
                }
                else if ((i % 2) == 0) {
                    // liked

                    for (int j = 0; j < 34; j++) {
                        String a = "No";
                        if (String.valueOf(tokens[i].trim()) != "Yes") {
                            // make it to No

                        }
                        liked[j] = String.valueOf(tokens[i].trim());
                    }
                }

            }
            LinkedList<String> heardA = new LinkedList<String>();
            for (int i = 0; i < heard.length; i++)
            {
                heardA.add(heard[i]);
            }
            
            LinkedList<String> likedA = new LinkedList<String>();
            for (int i = 0; i < liked.length; i++)
            {
                likedA.add(heard[i]);
            }
            
            String major = tokens[2].trim();
            String region = tokens[3].trim();
            String hobby = tokens[4].trim();

            StudentSurvy.add(new Student(major, region, hobby, likedA, heardA));
        }

        return StudentSurvy;

    }


    private LinkedList<Song> readSongTitles() throws FileNotFoundException {
        SongList = new LinkedList<Song>();
        File newFile = new File(SongTitlesPath);
        Scanner file = new Scanner(newFile);
        String s = file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] tokens = line.split(",");
            // if no 3 comma

            String title = tokens[0].trim();
            String artist = tokens[1].trim();
            int year = Integer.valueOf(tokens[2].trim());
            String genre = tokens[3].trim();

            SongList.add(new Song(title, artist, year, genre));
        }

        return SongList;

    }

}
