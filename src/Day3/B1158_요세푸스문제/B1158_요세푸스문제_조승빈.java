package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        Queue<Integer> circle = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            circle.offer(i);
        }

        sb.append("<");

        while(circle.size() != 1) {
            for (int i = 0; i < M - 1; i++) {
                circle.offer(circle.poll());
            }
            sb.append(circle.poll()).append(", ");
        }

        sb.append(circle.poll()).append(">");

        System.out.println(sb);
    }
}
