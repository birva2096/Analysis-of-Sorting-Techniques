package helpers;

import algorithms.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CSVHelper {

    public static void main(String[] args) throws IOException {
        //System.out.println(Arrays.toString(CSVToArray("src/csv/MOCK_DATA.txt")));
       InsertionSort.partialsort(CSVToArray("src/csv/temperature2.csv"));
    }

    public static double sortedMeasure(final double[] items) {
        int n = items.length;

        // Find the sorted positions
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = i;
        }
        Arrays.sort(sorted, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                double o1 = items[i1];
                double o2 = items[i2];
                return Double.compare(o1,o2);
            }

            public boolean equals(Object other) {
                return this == other;
            }
        });

        // Sum up the distances
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= Math.abs(sorted[i] - i);
        }

        double sortedness = (double)sum/n;
        sortedness = sortedness/n;
//        System.out.println(sortedness*2);
        return sortedness*2;
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
