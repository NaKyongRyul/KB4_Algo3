package Day7.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_곽승규 {
	static int [] dx = {-1, 1, 0,0};
	static int [] dy = {0, 0, -1,1}; // 상하좌우
	
	static int N;
	static int M;
	static int [][] graph;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = bf.readLine();
			for (int j = 0; j<M; j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}
		
		//System.out.println(Arrays.deepToString(graph));
		BFS(0,0);
		//System.out.println(Arrays.deepToString(graph));
		System.out.println(graph[N-1][M-1]);
	}
	
	static void BFS(int i, int j) {
		Queue<int []> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (graph[nx][ny] != 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						graph[nx][ny] = graph[now[0]][now[1]] + 1;
						queue.add(new int[] {nx, ny});
					}
				}
			}
			
		}
		
	}

}
