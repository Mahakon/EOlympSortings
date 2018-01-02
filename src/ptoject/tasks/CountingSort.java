package ptoject.tasks;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Сортировка подсчетом
 */
public class CountingSort {
    public static void main(String[] args) throws IOException {
        new CountingSort().run();
    }

    private void run() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

        String line = bufferedReader.readLine();

        int amount = Integer.parseInt(line);
        int[] array = new int[amount];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int max = Integer.parseInt(stringTokenizer.nextToken());
        int min = max;

        array[0] = max;

        for (int i = 1; i < amount; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        int[] helper = new int[max + 1 - min];

        for (int x : array) helper[x - min]++;
        int pos = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (int k = min; k <= max; k++) {
            for (int i = 0; i < helper[k - min]; i++) {
                array[pos++] = k;
                stringBuilder.append(array[pos - 1] + "");
                stringBuilder.append(" ");
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }
}
