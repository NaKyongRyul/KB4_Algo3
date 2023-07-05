package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_임재현 {
	static int N, K;
	static boolean[] visited = new boolean[100005];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());

		Queue<Integer> q = new ArrayDeque<Integer>();

		q.add(N);
		int ans = 0;
		if (N == K) {
			System.out.println(ans);
			q.clear();
			return;
		}
		while (!q.isEmpty()) {
			int size = q.size();
			ans++;
			while (size-- > 0) {
				int front = q.poll();
				if (front * 2 == K || front + 1 == K || front - 1 == K) {
					System.out.println(ans);
					return;
				}
				if (front * 2 < 100005 && !visited[front * 2]) {
					q.add(2 * front);
					visited[front * 2] = true;
				}
				if (front + 1 < 100005 && !visited[front + 1]) {
					q.add(front + 1);
					visited[front + 1] = true;
				}
				if (front - 1 >= 0 && !visited[front - 1]) {
					q.add(front - 1);
					visited[front - 1] = true;
				}
			}
		}
	}
}
