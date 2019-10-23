package algorithms;

//Implements Tail Call Elimination Quick Sort
public class QuickSort {
    private static int partition(double arr[], int low, int high)
    {
        double pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(double arr[])
    {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(double arr[], int low, int high)
    {
        while (low < high)
        {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);

            // If left part is smaller, then recur for left
            // part and handle right part iteratively
            if (pi - low < high - pi)
            {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
            }

            // Else recur for right part
            else
            {
                quickSort(arr, pi + 1, high);
                high = pi - 1;
            }
        }
    }
}
