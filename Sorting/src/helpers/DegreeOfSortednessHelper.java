package helpers;

import java.io.IOException;
import java.util.ArrayList;

public class DegreeOfSortednessHelper {
    public static void createCSVs(String[] fileNames, int numberOfTrials) throws IOException {
        for (int i=0;i<fileNames.length;i++
        ) {
            String name = fileNames[i];
            double[] datasetArray = CSVHelper.CSVToArray(name);
            CSVHelper.runAlgorithms(datasetArray, numberOfTrials,i,true);
        }
    }
}
