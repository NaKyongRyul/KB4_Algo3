package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int ans = 0;

        while (true) {
            if (q.size() == 1) {
                ans = q.peek();
                break;
            }
            if (q.size() == 2) {
                q.poll();
                ans = q.peek();
                break;
            }
            q.poll();

            Integer poll = q.poll();
            q.add(poll);
        }

        System.out.println(ans);

    }
}
