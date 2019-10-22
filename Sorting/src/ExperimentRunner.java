import algorithms.*;
import helpers.DegreeOfSortednessHelper;
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

        String[] fileNames = {"C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr0.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr1.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr2.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr3.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr4.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr5.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr6.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr7.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr8.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr9.txt",
                "C:\\Users\\imn1dtec\\IdeaProjects\\Analysis-of-Sorting-Techniques\\Sorting\\src\\csv\\temperature2\\arr10.txt",
        };
        int[] percentages = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        //PercentageSplittingHelper.createPercentages(fileNames,percentages,10);
        DegreeOfSortednessHelper.createCSVs(fileNames,10);

//        System.out.println("Given Array");
//        printArray(arr);
//
//        InsertionSort.sort(arr);
//
//        System.out.println("\nSorted array");
//        printArray(arr);
    }
}
