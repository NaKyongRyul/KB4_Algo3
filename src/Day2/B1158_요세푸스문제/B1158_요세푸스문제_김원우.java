package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> tmp = new ArrayDeque<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int cnt = 1;
        while (true) {
            if (deque.size() == 1) {
                while (!deque.isEmpty()) {
                    tmp.add(deque.removeFirst());
                }
                break;
            }
            if (cnt == k) {
                tmp.add(deque.removeFirst());
                cnt = 1;
                continue;
            }
            deque.add(deque.removeFirst());
            cnt++;
        }
        int len = tmp.size();
        System.out.print("<");

        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                System.out.print(tmp.removeFirst());
            }
            else System.out.print(tmp.removeFirst() + ", ");
        }
        System.out.print(">");

    }
}
