package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1158_요세푸스문제_오원식 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		String[] str = s.split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);

		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) {
			que.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < K; j++) {
				que.offer(que.poll());
			}

			sb.append(que.peek()).append(", ");
			que.poll();
		}
		
		sb.deleteCharAt(sb.length() -1 );
		sb.deleteCharAt(sb.length() -1 );
		sb.append(">");
		System.out.println(sb);
		
	}
}
