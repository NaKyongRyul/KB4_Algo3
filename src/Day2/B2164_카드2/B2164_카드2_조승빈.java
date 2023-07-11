package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_카드2_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            Q.offer(i);
        }

        while(Q.size() != 1) {
            Q.remove();
            Q.offer(Q.remove());
        }

        System.out.println(Q.peek());
    }
}
