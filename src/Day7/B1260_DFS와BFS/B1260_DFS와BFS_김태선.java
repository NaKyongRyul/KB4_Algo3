package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_김태선 {

	static StringBuilder sb = new StringBuilder();
	static boolean[] isVisited;
	static int[][] arr;
	
	static int N, M, V;
	
	static Queue<Integer> que = new ArrayDeque<>();
	
	
	public static void dfs(int V) {
		
		isVisited[V] = true;
		sb.append(V + " ");
		
		for(int i = 0 ; i <= N ; i++) {
			if(arr[V][i] == 1 && !isVisited[i])
				dfs(i);
		}
		
	}

	
	public static void bfs(int V) {
		
		que.add(V);
		isVisited[V] = true;
		
		while(!que.isEmpty()) {
			
			V = que.poll();
			sb.append(V + " ");
			
			for(int i = 1 ; i <= N ; i++) {
				if(arr[V][i] == 1 && !isVisited[i]) {
					que.add(i);
					isVisited[i] = true;
				}
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] =  1;	
		}
			
			dfs(V);
			sb.append("\n");
			isVisited = new boolean[N+1];
			
			bfs(V);
			
			System.out.println(sb);
		
		}
	
}
