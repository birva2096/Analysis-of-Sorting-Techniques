package algorithms;

import helpers.CSVHelper;
import helpers.FileHelper;

import java.util.Arrays;
import java.util.Collections;

public class InsertionSort {
    public static void sort(double arr[])
    {       //this version is modified to avoid the stack overflow exception
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void partialsort(double arr[]) {
        //Sorting in descending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] >= arr[j]) {
                    double x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }
        FileHelper.arrayToCSV(arr, "arr10.txt");

        // System.out.println("m here");
        int[] flag = new int[10];

        //Should be always 1
        CSVHelper.sortedMeasure(arr);

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            double measure = CSVHelper.sortedMeasure(arr);
            if (measure <= 0.1 && flag[0]==0) {
                FileHelper.arrayToCSV(arr, "arr1.txt");
                flag[0] = 1;

            } else if (measure <= 0.2 && flag[1]==0) {
                FileHelper.arrayToCSV(arr, "arr2.txt");
                flag[1] = 1;

            } else if (measure <= 0.3 && flag[2]==0) {
                FileHelper.arrayToCSV(arr, "arr3.txt");
                flag[2] = 1;

            } else if (measure <= 0.4 && flag[3]==0) {
                FileHelper.arrayToCSV(arr, "arr4.txt");
                flag[3] = 1;

            } else if (measure <= 0.5 && flag[4]==0) {
                FileHelper.arrayToCSV(arr, "arr5.txt");
                flag[4] = 1;

            } else if (measure <= 0.6 && flag[5]==0) {
                FileHelper.arrayToCSV(arr, "arr6.txt");
                flag[5] = 1;

            } else if (measure <= 0.7 && flag[6]==0) {
                FileHelper.arrayToCSV(arr, "arr7.txt");
                flag[6] = 1;

            } else if (measure <= 0.8 && flag[7]==0) {
                FileHelper.arrayToCSV(arr, "arr8.txt");
                flag[7] = 1;
            } else if (measure <= 0.9 && flag[8]==0) {
                FileHelper.arrayToCSV(arr, "arr9.txt");
                flag[8] = 1;
            }
        }
        FileHelper.arrayToCSV(arr, "arr0.txt");
    }
}

