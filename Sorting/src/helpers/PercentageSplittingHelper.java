package helpers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PercentageSplittingHelper {

    private static double[] splitArray(double[] arr, int start, int end) {
        ArrayList<Double> subArray = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (i < arr.length)
                subArray.add(arr[i]);
        }
        return subArray.stream().mapToDouble(i -> i).toArray();
    }

    public static void createPercentages(String[] filePaths, String[] fileNames, int[] percentages, int numberOfTrials) throws IOException {
        for (int i=0;i<filePaths.length;i++
        ) {
            double[] datasetArray = CSVHelper.CSVToArray(filePaths[i]);
            createSubarrays(fileNames[i], datasetArray, percentages, numberOfTrials);
        }
    }

    public static void createSubarrays(String fileName, double[] array, int[] percentages, int numberOfTrials) throws IOException {
        for (int percentage : percentages) {
            int n = array.length;
            int size = (n * percentage) / 100;
            System.out.println("Size : " + size);
            double[] subArray = splitArray(array, 0, size);
            SortingHelper.runAlgorithms(fileName, subArray, numberOfTrials, 0, false);
        }
    }
}
