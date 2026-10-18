import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void swap(List <Integer> a, int i, int j) {
        int tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
    public static int partition(List<Integer> a, int low, int high) {
        int pivot = a.get(high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (a.get(j) < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return i;
    }
    public static int findMedian(List<Integer> arr, int low, int high) {
        // Write your code here
        if (low < high) {
            int p = partition(arr, low, high);
            if (p == arr.size()/2) return arr.get(p);
            if (p > arr.size()/ 2) return findMedian(arr, low, p - 1);
            else return findMedian(arr, p + 1, high);
        }
        return arr.get(arr.size()/2);
    }

}

public class FindTheMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.findMedian(arr, 0, arr.size() - 1);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
