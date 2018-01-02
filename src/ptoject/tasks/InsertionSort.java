package ptoject.tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Библиотечный метод
 */
public class InsertionSort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter("output.txt");
        int N = scan.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 1; i < arr.length; i++) {
            int pos = i;
            boolean swaped = false;
            while (pos > 0 && arr[pos] < arr[pos - 1]) {
                int temp = arr[pos];
                arr[pos] = arr[pos - 1];
                arr[pos - 1] = temp;
                pos--;
                swaped = true;
            }

            if(swaped) {
                printArr(arr, pw);
            }
        }
        pw.close();
    }

    static void printArr(int[] arr, PrintWriter pw) {
        for (int i = 0; i < arr.length; i++) {
            pw.write(arr[i] + " ");
        }
        pw.write("\n");
    }
}
