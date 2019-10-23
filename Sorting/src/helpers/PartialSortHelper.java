package helpers;

import algorithms.InsertionSort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import static helpers.CSVHelper.CSVToArray;

public class PartialSortHelper {
    //This method is used to create partially sorted array from an input csv
    public static void main(String[] args) throws IOException {
        InsertionSort.partialsort(CSVToArray("/Users/birvapatel/IdeaProjects/Analysis-of-Sorting-Techniques/Sorting/src/csv/data2.csv"));
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
        return (sortedness/n)*2;
    }
}
