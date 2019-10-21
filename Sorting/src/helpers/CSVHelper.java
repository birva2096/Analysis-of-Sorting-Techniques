package helpers;

import algorithms.BubbleSort;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(CSVToArray("src/csv/MOCK_DATA.csv")));
    }

    public static void runAlgorithms(double[] arr, int numberOfTrials) throws IOException {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        double avg_rt = 0;
        double avg_mem = 0;

        for (int i = 0; i < numberOfTrials; i++) {

            long start = System.currentTimeMillis();
            BubbleSort.sort(arr);
            long end = System.currentTimeMillis();

            // Run the garbage collector
            //runtime.gc();
            //System.out.println("trial " + (i + 1) + " : " + (end - start));
            avg_rt += end - start;
            long memory = runtime.totalMemory() - runtime.freeMemory();
            avg_mem += memory;
        }

        avg_rt = (double) avg_rt / numberOfTrials;
        System.out.println("RunTime : " + avg_rt);
        avg_mem = (double) avg_mem / numberOfTrials;
        System.out.println("Memory : " + avg_mem);
        FileHelper.inputToCSV(String.valueOf(arr.length), String.valueOf(avg_rt), String.valueOf(avg_mem), "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\plotPoints\\BubbleSort_temperature2.txt");
    }

    public static double[] CSVToArray(String filepath) throws FileNotFoundException, IOException {
        //Create arraylist of doubles
        List<Double> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    records.add(Double.parseDouble(values[i]));
                }

            }

            //return array of doubles
            return records.stream().mapToDouble(i -> i).toArray();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;

    }
}
