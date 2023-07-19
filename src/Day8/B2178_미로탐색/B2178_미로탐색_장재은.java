package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2178_미로탐색_장재은 {
	
	static int N;
	static int M;
	static int [][] arr;
	static int [][] dist;
	
	public static void bfs(int x, int y) {
		Queue <Integer> que = new ArrayDeque <>();
		que.add(x);
		que.add(y);
		int ax, ay;
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		dist[x][y] = 1;
		
		while(!que.isEmpty()) {
			x = que.poll();
			y = que.poll();
			
			if(x == N && y == M) break;
			
			for(int i=0; i<4; i++) {
				ax = x + dx[i];
				ay = y + dy[i];
				
				if(ax < 1 || ay < 1 || ax > N || ay > M)
					continue;
				if(arr[ax][ay] == 0)
					continue;
				
				if(dist[ax][ay] < 1) {
					dist[ax][ay] = dist[x][y] + 1;
					que.add(ax);
					que.add(ay);
				}
			}
		}
		System.out.println(dist[N][M]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int [N+1][M+1];
		dist = new int [N+1][M+1];
		
		for(int i=1; i<N+1; i++) {
			String [] stk = br.readLine().split("");
			for(int j=1; j<M+1; j++) {
				arr[i][j] = Integer.parseInt(stk[j-1]);
			}
		}
		bfs(1,1);
	}
}