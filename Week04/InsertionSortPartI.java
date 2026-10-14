import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < n; i++) {
            int j  = i - 1;
            int tmp = arr.get(i);
            while (j >= 0 && arr.get(j) > tmp) {
                arr.set(j + 1, arr.get(j));
                j--;
                for (int num : arr) System.out.print(num + " ");
                System.out.println();
            }
            if (j != i - 1) {
                arr.set(j + 1, tmp);
                for (int num : arr) System.out.print(num + " ");
                System.out.println();
            }
        }
    }
}

public class InsertionSortPartI {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
