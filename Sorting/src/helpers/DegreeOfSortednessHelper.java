package helpers;

import java.io.IOException;
import java.util.ArrayList;

public class DegreeOfSortednessHelper {
    public static void createCSVs(String[] filePaths, String name, int numberOfTrials) throws IOException {
        for (int i=0;i<filePaths.length;i++
        ) {
            double[] datasetArray = CSVHelper.CSVToArray(filePaths[i]);
            SortingHelper.runAlgorithms(name,datasetArray, numberOfTrials,i,true);
        }
    }
}
