import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int j  = i - 1;
            int tmp = arr.get(i);
            while (j >= 0 && arr.get(j) > tmp) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, tmp);
            for (int num : arr) System.out.print(num + " ");
            System.out.println();
        }

    }

}

public class InsertionSortPartII {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result1.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
