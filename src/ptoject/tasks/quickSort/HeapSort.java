package ptoject.tasks.quickSort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static int size = 100_000;

    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;


    public static void buildheap(int []a) {
        n = a.length-1;
        for(int i=n/2; i>=0; i--){
            maxheap(a,i);
        }
    }

    public static void maxheap(int[] a, int i) {
        left = 2*i;
        right = 2*i+1;

        if(left <= n && a[left] > a[i]){
            largest=left;
        } else {
            largest=i;
        }

        if(right <= n && a[right] > a[largest]) {
            largest=right;
        }
        if(largest!=i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(int[] myarray) {
        a = myarray;
        buildheap(a);
        for(int i=n; i>0; i--) {
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter("output.txt");
        StringBuilder str = new StringBuilder();
        int arr[] = new int[size];

        int s = 0;
        while (scan.hasNextInt()) {
            arr[s++] = scan.nextInt();
        }

        arr = Arrays.copyOf(arr, s);
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i] + " ");
        }

        pw.write(str.toString());
        pw.close();
    }
}
