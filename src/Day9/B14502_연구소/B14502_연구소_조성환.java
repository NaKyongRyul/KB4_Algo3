package Day9.B14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_연구소_조성환 {

	static int N;
	static int M;
	static int max;
	static int[][] lab;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void DFS(int wall) {
	    if(wall == 3) {
	        BFS();
	        return;
	    }
	    
	    for(int i =0; i<N; i++) {
	        for(int j =0; j<M; j++) {
	            if(lab[i][j] == 0) {
	                lab[i][j] = 1;
	                DFS(wall + 1);
	                lab[i][j] = 0; 
	            }
	        }
	    }
	}
	
	public static boolean checkValid(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N)
			return false;
		else
			return true;
	}
	
	public static void BFS() {
		int [][] virus = new int [N][M];
		Queue<int[]> que = new ArrayDeque<>();
		
	    for(int i =0; i<N; i++) {
	        for(int j =0; j<M; j++) {
	        	virus[i][j] = lab[i][j];
	        }
	    }
		
	    for(int i =0; i<N; i++) {
	        for(int j =0; j<M; j++) {
	        	if(virus[i][j] == 2) {
	        		que.add(new int[]{i,j});
	        	}
	        }
	    }
		
		// BFS
		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int i = 0; i < 4; i++) {
				int next_y = now[0] + dx[i];
				int next_x = now[1] + dy[i];
				
				if(checkValid(next_x, next_y) && virus[next_y][next_x] == 0) {					
					virus[next_y][next_x] = 2;
					que.offer(new int[] { next_y, next_x });
				}else {
					continue;
				}
			}
		}
		
		check_safe(virus);
	}
	
	public static void check_safe(int [][] arr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {		
				if (arr[i][j] ==  0) {
					cnt += 1;
				}
			}
		}
		if (cnt > max) {
			max = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0);

		System.out.println(max);
	}

}
