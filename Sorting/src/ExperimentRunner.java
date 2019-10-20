import algorithms.*;
import com.sun.scenario.effect.Merge;

public class ExperimentRunner {
    static void printArray(double arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        double arr[] = {12, -14, 13, -5, 6, 8};

        System.out.println("Given Array");
        printArray(arr);

        InsertionSort.sort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
