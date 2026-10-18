import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1{

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int partition(List<Integer> a, int low, int high) {
        int pivot = a.get(low);
        int i = low - 1, j = high + 1;
        while (true) {
            do {
                i++;
            } while (a.get(i) < pivot);
            do {
                j--;
            } while(a.get(j) > pivot);
            if (i >= j) return j;

            int tmp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, tmp);
        }
    }
    public static List<Integer> quickSort(List<Integer> arr, int low, int high) {
        // Write your code here
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }

}

public class QuickSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result1.quickSort(arr, 0, arr.size() - 1);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
