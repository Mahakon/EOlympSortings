package ptoject.tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Метод минимума
 */
public class SelectionSort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter("output.txt");
        int N = scan.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        int index = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[pos] > arr[j]) {
                    pos = j;
                }
            }

            if (i == index && pos != index) {
                counter++;
                index = pos;
            } else if (pos == index && i != index) {
                index = i;
                counter++;
            }

            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }

        pw.write(counter + "");
        pw.close();
    }
}