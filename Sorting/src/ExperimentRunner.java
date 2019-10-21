import algorithms.*;
import helpers.PercentageSplittingHelper;

import java.io.IOException;

public class ExperimentRunner {
    static void printArray(double arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        //double arr[] = {12, -14, 13, -5, 6, 8};

        String[] fileNames = {"C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2.csv"};
        int[] percentages = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        PercentageSplittingHelper.createPercentages(fileNames,percentages,10);

//        System.out.println("Given Array");
//        printArray(arr);
//
//        InsertionSort.sort(arr);
//
//        System.out.println("\nSorted array");
//        printArray(arr);
    }
}
