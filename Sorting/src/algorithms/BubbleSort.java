package algorithms;
//Implements Bubble Sort
public class BubbleSort {
    public static void sort(double arr[])
    {
	//stores size of the array
        int n = arr.length;
	
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
