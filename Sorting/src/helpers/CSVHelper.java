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

        System.out.println(Arrays.toString(CSVToArray("src/csv/MOCK_DATA.txt")));
        runAlgorithms();
    }

    public static void runAlgorithms() throws IOException {
        double[] arr = CSVToArray("src/csv/MOCK_DATA.txt");
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();

        for (int i = 0; i < 10; i++) {

            long start = System.currentTimeMillis();
            BubbleSort.sort(arr);
            long end = System.currentTimeMillis();

            // Run the garbage collector
            runtime.gc();
            System.out.println("trial " + (i+1) + " : " + (end - start));
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println(memory);
        }
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
