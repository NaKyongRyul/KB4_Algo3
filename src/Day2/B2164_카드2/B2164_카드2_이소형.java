package Day2.B2164_카드2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_이소형 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
