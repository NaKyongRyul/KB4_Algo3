package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2178_미로탐색_나웅기 {
	static int n;
	static int m;
	static int [][] arr;
	static boolean [][] visited;
	final static int [] di = {-1, 0, 1, 0};
	final static int [] dj = {0, 1, 0, -1};
	static int res;
	static Queue<Dot> que;
	
	static class Dot{
		int x;
		int y;
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void maze(int x, int y) {
		
		que.add(new Dot(x, y));
		while (!que.isEmpty()) {
			Dot dot = que.poll();
			for (int i = 0; i<4; i++) {
				int ci = dot.x+di[i];
				int cj = dot.y+dj[i];
				if ((ci>=0 && ci< n && cj >=0 && cj < m) && visited[ci][cj] == false && arr[ci][cj] == 1) {
					visited[ci][cj] = true;
					arr[ci][cj] = arr[dot.x][dot.y] + 1;
					que.add(new Dot(ci, cj));
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] str = reader.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		arr = new int [n][m];
		visited = new boolean [n][m];
		
		for (int i = 0; i<n; i++) {
			str = reader.readLine().split("");
			for (int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		que = new ArrayDeque<>();
		res = 99999999;
		visited[0][0] = true;
		maze(0,0);
		System.out.println(arr[n-1][m-1]);
	}
}
