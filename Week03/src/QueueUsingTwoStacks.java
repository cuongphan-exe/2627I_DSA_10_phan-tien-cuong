import java.io.*;
import java.util.Scanner;
import java.util.Stack;


public class QueueUsingTwoStacks {
    public static void fill(Stack<Integer> enq, Stack<Integer> deq) {
        while(!enq.empty()) {
            deq.push(enq.pop());
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        Stack<Integer> enqueue = new Stack<>();
        Stack<Integer> dequeue = new Stack<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int num = sc.nextInt();
                enqueue.push(num);
            }
            else if (type == 2) {
                if (dequeue.empty()) fill(enqueue, dequeue);
                dequeue.pop();
            }
            else {
                if (dequeue.empty()) fill(enqueue, dequeue);
                System.out.println(dequeue.peek());
            }
        }
    }
}
