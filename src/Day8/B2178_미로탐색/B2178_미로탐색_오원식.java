package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class B2178_미로탐색_오원식 {

	static int N;
	static int M;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static int[][] distance;
	static boolean[][] isVisited;

	public static boolean checkValid(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}

	public static void BFS(int x, int y) {
		Queue<int[]> que = new ArrayDeque<>();
		int[] start = { x, y };
		distance[x][y] = 1;
		isVisited[x][y] = true;
		que.offer(start);

		while (!que.isEmpty()) {
			start = que.poll();
			x = start[0];
			y = start[1];

			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (!checkValid(newX, newY))
					continue;

				if (arr[newX][newY] == 0)
					continue;

				if (isVisited[newX][newY])
					continue;

				distance[newX][newY] = distance[x][y] + 1;
				int[] temp = { newX, newY };
				que.offer(temp);
				isVisited[newX][newY] = true;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		isVisited = new boolean[N][M];
		distance = new int[N][M];

		BFS(0, 0);

		System.out.println(distance[N - 1][M - 1]);

	}

}
