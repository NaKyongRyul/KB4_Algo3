package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색 {
	static int N;
	static int M;
	static int maze[][];
	
	static void search() {
		Queue<Integer[]> que = new ArrayDeque<>();
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int nx = 0;
		int ny = 0;
		
		que.offer(new Integer[] {0, 0});
		
		while (!que.isEmpty()) {
			Integer[] now = que.poll();
			int x = now[0];
			int y = now[1];
			
			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) { 
					continue; // N x M 범위 내에서만 실행되도록 함
				}
				
				if (maze[nx][ny] == 1) { // 전진할 수 있는 칸(1)
					que.offer(new Integer[] {nx, ny});
					maze[nx][ny] = maze[x][y] + 1; // +1
				}
				else {
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(token.nextToken()); 
		M = Integer.parseInt(token.nextToken()); // (1, 1)에서 (N, M)으로 이동
		// 4, 6
		
		maze = new int[N][M];
		
		for(int n = 0; n<N; n++) {
			//token = new StringTokenizer(bf.readLine());
			char[] arr = new char[M];
			arr = bf.readLine().toCharArray();
			for(int m=0; m<M; m++) {
				maze[n][m] = (int)arr[m]-48;
			}
		} // 2차원 배열에 입력 
		// System.out.println(Arrays.deepToString(maze));
		
		search();
		
		System.out.println(maze[N-1][M-1]); // (N, M)까지 가는 데 거쳐가야 하는 최소 칸 수
	}
}
