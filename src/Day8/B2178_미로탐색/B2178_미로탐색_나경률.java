package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B2178_미로탐색_나경률 {
	static int N, M;
	static int[][] arr;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] dist;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dist = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] =(int)(s.charAt(j) - '0');
			}
		}
		dist[0][0] = 1;
		bfs(0,0);
		sb.append(dist[N-1][M-1]);
		System.out.println(sb);
	}

	public static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x,y));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
//			System.out.println(node.x + ", " + node.y);
			for(int i=0; i<4; i++) {
				int nx = node.x + dir[i][0];
				int ny = node.y + dir[i][1];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;//미로를 벗어나면 
				if(arr[nx][ny] == 0) continue;//배열값이 0이어서 갈 수 없으면 
				if(dist[nx][ny] != 0) continue;//이미 방문을 했다면 
				
				dist[nx][ny] = dist[node.x][node.y] + 1;
				que.add(new Node(nx, ny));
			}
		}
	}
}
