package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new ArrayDeque<Integer>();

		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		System.out.print("<");
		while (!que.isEmpty()) {
			for (int i = 0; i < M; i++) {
				if(que.isEmpty()) {
					break;
				}
				int a = que.poll();
				if (i == M-1) {
					System.out.print(a);
					if(que.size() != 0) {
						System.out.print(", ");
					}
				}else {
					que.add(a);
				}
				
			}
		}
		System.out.println(">");
	}
}
