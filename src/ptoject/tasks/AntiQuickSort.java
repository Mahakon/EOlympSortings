package ptoject.tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Анти - QuickSort
 */
public class AntiQuickSort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter("output.txt");
        int N = scan.nextInt();
        int[] arr = new int[70_000];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;

        if (N == 2) {
            pw.write("2 1");
            pw.close();
            return;
        } else if(N == 1) {
            pw.write("1");
            pw.close();
            return;
        }

        int right = 2;
        for (int i = 4; i <= N; i++) {
            int mid = (right + 1) / 2;
            arr[right + 1] = i;
            swap(arr, mid, right + 1);
            right++;
        }

        for (int i = 0; i <= right; i++) {
            pw.write(arr[i] + " ");
        }

        pw.close();
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
