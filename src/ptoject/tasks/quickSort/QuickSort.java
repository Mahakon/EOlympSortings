package ptoject.tasks.quickSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter pw = new BufferedWriter(new FileWriter("output.txt"));
        long arr[] = new long[100_000];

        String[] numbers = bf.readLine().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Long.parseLong(numbers[i]);
        }

        quickSort(arr, 0, numbers.length - 1);

        for (int i = 0; i < numbers.length; i++) {
            pw.write(arr[i] + " ");
        }
        pw.close();
    }

    public static void quickSort(long arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        int m = partition(arr, left, right);
        int index = m;
        while (index - 1 >= 0 && arr[index - 1] == arr[m]) {
            index--;
        }

        quickSort(arr, left, index - 1);
        quickSort(arr, m + 1, right);
    }

    public static int partition(long[] arr, int left, int right) {
        Random rnd = new Random();
        int index = rnd.nextInt(right - left) + left;
        swap(arr, left, index);

        long x = arr[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= x) {
                j++;
                swap(arr, i , j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    public static void swap(long[] arr, int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}