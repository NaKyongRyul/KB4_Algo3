package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_신선영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque <Integer> deque = new ArrayDeque<>();
        Deque <Integer> arr = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            for (int k = 0; k < K - 1; k++) {
                deque.add(deque.remove());
            }
            arr.add(deque.remove());
        }

        System.out.print('<');
        for (int i = 0; i < N - 1; i++) {
            System.out.print(arr.remove() + ", ");
        }

        System.out.println(arr.remove() + ">");
    }
}
