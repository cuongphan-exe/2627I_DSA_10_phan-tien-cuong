import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static Stack<StringBuffer> lastStat = new Stack<>();
    public static StringBuffer res = new StringBuffer();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                lastStat.push(new StringBuffer(res));
                String s = sc.next();
                res.append(s);
            }
            else if (type == 2) {
                lastStat.push(new StringBuffer(res));
                int k = sc.nextInt();
                res.delete(res.length() - k, res.length());
            }
            else if (type == 3) {
                int k = sc.nextInt();
                System.out.println(res.charAt(k-1));
            }
            else {
               res = new StringBuffer(lastStat.pop());
            };
        }
    }
}
