package helpers;

import java.io.IOException;
import java.util.ArrayList;

public class PercentageSplittingHelper {

    public static void main(String args[]) throws IOException {
    }

    private static double[] splitArray(double[] arr, int start, int end) {
        ArrayList<Double> subArray = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (i < arr.length)
                subArray.add(arr[i]);
        }
        return subArray.stream().mapToDouble(i -> i).toArray();
    }

    public static void createPercentages(String[] fileNames, int[] percentages, int numberOfTrials) throws IOException {
        ArrayList<double[]> dataArrays = new ArrayList<>();
        for (String name : fileNames
        ) {
            double[] datasetArray = CSVHelper.CSVToArray(name);
            dataArrays.add(datasetArray);
        }
        createSubarrays(dataArrays, percentages, numberOfTrials);
    }

    public static void createSubarrays(ArrayList<double[]> dataArrays, int[] percentages, int numberOfTrials) throws IOException {
        for (double[] array : dataArrays
        ) {
            for (int percentage : percentages) {
                int n = array.length;
                int size = (n * percentage) / 100;
                System.out.println("Size : " + size);
                double[] subArray = splitArray(array, 0, size);
                CSVHelper.runAlgorithms(subArray, numberOfTrials);
            }
        }
    }
}
