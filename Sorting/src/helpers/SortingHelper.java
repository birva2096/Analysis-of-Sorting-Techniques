package helpers;

import algorithms.*;

import java.io.IOException;

public class SortingHelper {

    public static void runAlgorithms(String fileName, double[] arr, int numberOfTrials, int fileIndex, Boolean degreeOfSortedness) throws IOException {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        double avg_rt = 0;
        double avg_mem = 0;

        for(int j=0;j<5;j++) {

            for (int i = 0; i < numberOfTrials; i++) {

                long start = System.currentTimeMillis();
                switch (j){
                    case 0:
                        BubbleSort.sort(arr);
                    case 1:
                        InsertionSort.sort(arr);
                    case 2:
                        MergeSort.sort(arr);
                    case 3:
                        QuickSort.sort(arr);
                    case 4:
                        SelectionSort.sort(arr);
                }

                long end = System.currentTimeMillis();

                avg_rt += end - start;
                long memory = runtime.totalMemory() - runtime.freeMemory();
                avg_mem += memory;
            }

            avg_rt = (double) avg_rt / numberOfTrials;
            System.out.println("RunTime : " + avg_rt);
            avg_mem = (double) avg_mem / numberOfTrials;
            System.out.println("Memory : " + avg_mem);
            if (degreeOfSortedness)
                FileHelper.inputToCSV(String.valueOf((double) fileIndex / 10), String.valueOf(avg_rt), String.valueOf(avg_mem), "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\plotPoints\\degreeOfSortedness\\"+ fileName +"_" + j + ".txt");
            else
                FileHelper.inputToCSV(String.valueOf(arr.length), String.valueOf(avg_rt), String.valueOf(avg_mem), "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\plotPoints\\sizeOfDatasets\\"+ fileName +"_" + j + ".txt");
        }
    }
}
