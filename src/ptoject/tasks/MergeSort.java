package ptoject.tasks;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Сортировка слияния
 */
public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter pw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(bf.readLine());
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            Node node = new Node(Integer.parseInt(token.nextToken()),
                    Integer.parseInt(token.nextToken()));
            arr[i] = node;
        }

        arr = sort(arr);
        for (Node node : arr) {
            pw.write(node.first + " " + node.second + "\n");
        }

        pw.close();
    }

    static class Node {
        int first;
        int second;

        Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Node[] sort(Node[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int average = arr.length / 2;
        Node[] leftArr = Arrays.copyOf(arr, average);
        Node[] rightArr = Arrays.copyOfRange(arr, average, arr.length);

        leftArr = sort(leftArr);
        rightArr = sort(rightArr);

        int k = 0, j = 0;
        while (k < leftArr.length && j < rightArr.length) {
            if (leftArr[k].first <= rightArr[j].first) {
                arr[k + j] = leftArr[k++];
            } else {
                arr[k + j] = rightArr[j++];
            }
        }

        while (k < leftArr.length) {
            arr[k + j] = leftArr[k++];
        }

        while (j < rightArr.length) {
            arr[k + j] = rightArr[j++];
        }

        return arr;
    }
}
