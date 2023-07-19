package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1697_숨바꼭질_오원식 {
	static int N;
	static int K;
	static int[] distance;
	static boolean[] isVisited;
	static final int value = 100001;

//	public static boolean checkValid(int x) {
//		if (x + 1 > value || x - 1 < 0 || x * 2 > value)
//			return false;
//		return true;
//	}

	public static int BFS(int N) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(N);
		isVisited[N] = true;

		while (!que.isEmpty()) {

			int start = que.poll();

			if (start == K) {
				return distance[K];
			}

			if (start + 1 < value && !isVisited[start + 1]) {
				que.offer(start + 1);
				distance[start + 1] = distance[start] + 1;
				isVisited[start + 1] = true;
			}

			if (start - 1 > -1 && !isVisited[start - 1]) {
				que.offer(start - 1);
				distance[start - 1] = distance[start] + 1;
				isVisited[start - 1] = true;
			}

			if (start * 2 < value && !isVisited[start * 2]) {
				que.offer(start * 2);
				distance[start * 2] = distance[start] + 1;
				isVisited[start * 2] = true;
			}
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);

		isVisited = new boolean[value];
		distance = new int[value];

		System.out.println(BFS(N));

	}

}
