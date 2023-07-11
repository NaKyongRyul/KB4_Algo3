import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_송봉섭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new ArrayDeque<>();

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        //System.out.println(queue); // [1, 2, 3, 4, 5, 6]

        for (int i = N; i > 1; i--) {
            queue.poll();
            int top = queue.poll();
            queue.offer(top);
        }
        System.out.println(queue.poll());

    }
}
