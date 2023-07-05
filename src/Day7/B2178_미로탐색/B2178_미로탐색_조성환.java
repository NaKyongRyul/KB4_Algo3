package Day7.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_조성환 {

	static int N, M;
	static boolean[][] isVisited;
	static int[][] maze;

	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };

	static void searchMaze() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { 0, 0 });
		isVisited[0][0] = true;
		while (!que.isEmpty()) {
			int[] nowNode = que.poll();
			if (nowNode[0] == N-1 && nowNode[1] == M-1) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int new_y = dy[i] + nowNode[0];
				int new_x = dx[i] + nowNode[1];
				if (new_y >= 0 && new_y < N && new_x >= 0 && new_x < M) {
					if (isVisited[new_y][new_x] != true && maze[new_y][new_x] == 1) {
						isVisited[new_y][new_x] = true;
						maze[new_y][new_x] += maze[nowNode[0]][nowNode[1]];
						que.add(new int[] { new_y, new_x });
					}
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		isVisited = new boolean[N][M];
		searchMaze();
		
		System.out.println(maze[N-1][M-1]);
	}

}
