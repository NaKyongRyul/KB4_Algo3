package Day2.B2164_카드2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_임재현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 2) {
            q.poll();
            int top = q.poll();
            q.add(top);
        }

        if (q.size() == 1)
            System.out.println(q.peek());
        else {
            q.poll();
            System.out.println(q.peek());
        }
        sc.close();
    }
}
