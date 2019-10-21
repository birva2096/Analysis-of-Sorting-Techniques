package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

    //Constructor
    public FileHelper (String theSize, String theRuntime, String theMemory, String filename) {

        String size = theSize;						//size of data
        String avgRuntime = theRuntime;				//average runtime
        String avgMemory = theMemory;				//average memory used
        String theFile = filename;				//the name of the file to write to

        //function call
        inputToCSV(size, avgRuntime, avgMemory, theFile);
    }

    //function accepts four parameters to write to a CSV file
    public static void inputToCSV(String theSize, String theRuntime, String theMemory, String filename)
    {
        try
        {
            //create a file object and pass in file name
            File theFile = new File(filename);

            //create a file writer object
            FileWriter csvWriter = new FileWriter(theFile, true);

            csvWriter.write(theSize + " ");
            csvWriter.write(theRuntime + " ");
            csvWriter.write(theMemory + " ");

            csvWriter.write("\n");

            csvWriter.close();

        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
