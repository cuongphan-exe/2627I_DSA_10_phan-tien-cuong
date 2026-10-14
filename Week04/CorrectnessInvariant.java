import java.util.*;

public class CorrectnessInvariant {
    public static void insertionSort(List <Integer> a) {
        for (int i = 1; i < a.toArray().length; i++) {
            int j  = i - 1;
            int tmp = a.get(i);
            while (j >= 0 && a.get(j) > tmp) {
                a.set(j + 1, a.get(j));
                j--;
            }
            a.set(j + 1, tmp);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        insertionSort(a);
        for (int i = 0; i < n; i++) System.out.print(a.get(i) + " ");
    }
}