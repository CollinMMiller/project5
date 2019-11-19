package prj5;

import java.io.FileNotFoundException;

/**
 * Main class to run project
 * @author Collin Miller (collinm2)
 * @version (2019.11.17)
 */

public class Input
{
    /**
     * Main method
     * @param args command line arguments
     * @throws FileNotFoundException if file is not found
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        FileReader fr = new FileReader(args[0], args[1]);
        new GUIWindow(fr.createDatabase());
    }
}
