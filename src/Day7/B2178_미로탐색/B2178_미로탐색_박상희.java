package Day7.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_박상희 {
	static int N;
	static int M;
	static int maze[][]; // 미로
	
	static void escape() {
		Queue<Integer[]> que = new LinkedList<>();
		
		int dx[] = {-1, 1, 0, 0}; // 상, 하, 좌, 우
		int dy[] = {0, 0, -1, 1}; // 상, 하, 좌, 우
		int nx = 0;
		int ny = 0;
		
		que.offer(new Integer[] {0, 0}); // 처음 시작 : {0, 0} ((1, 1)에서 출발하므로)
		while (!que.isEmpty()) {
			Integer[] now = que.poll();
			int x = now[0];
			int y = now[1];
			
			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) { // 범위 벗어나면 다음 반복으로
					continue;
				}
				
				if (maze[nx][ny] == 1) { // 이동할 수 있는 칸이면
					que.offer(new Integer[] {nx, ny});
					maze[nx][ny] = maze[x][y] + 1; // 지나가는 칸 수 카운트
				}
				else {
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		maze = new int[N][M];
		for (int n = 0; n < N; n++) {
			String str = bf.readLine();
			
			for (int m = 0; m < M; m++) {
				maze[n][m] = Integer.parseInt(str.charAt(m) + "");
			}
		}
		
		escape();
		
		System.out.println(maze[N - 1][M - 1]); // (N, M) 위치로 이동할 때 지나야 하는 최소의 칸 수
	}
}
