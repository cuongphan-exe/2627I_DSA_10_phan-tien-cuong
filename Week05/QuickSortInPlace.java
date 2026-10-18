import java.util.*;

public class QuickSortInPlace {
    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[high];
        a[high] = tmp;
        return i;
    }
    public static void printArr(int[] a) {
        for (int num: a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            printArr(a);

            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        quickSort(a, 0, n - 1);
    }
}