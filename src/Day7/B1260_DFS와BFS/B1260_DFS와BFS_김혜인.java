package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B1260_DFS와BFS_김혜인 {
	static int[][] arr;
	static boolean[] isvisited = new boolean[1001]; // 입력 케이스 = 1000
	
	static int N, M, V;
	
	static Queue<Integer> q = new LinkedList<>();    
	static StringBuilder st = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		N = Integer.parseInt(token[0]);	//정점수
		M = Integer.parseInt(token[1]);	//간선수
		V = Integer.parseInt(token[2]);	//탐색시작 정점	

		arr = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			token = br.readLine().split(" ");
			int node1 = Integer.parseInt(token[0]);
			int node2 = Integer.parseInt(token[1]);
			
			//무향(양방향) 그래프
			arr[node1][node2] = 1;
			arr[node2][node1] = 1;
		}
		
		dfs(V);
		st.append("\n");
		Arrays.fill(isvisited, false);		//방문배열 초기화
		
		bfs(V);
		System.out.println(st);
		st.setLength(0);
	
}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(graph[i][j]);
//			}
//			System.out.println();
//		}
		
	
	private static void dfs(int v) {		//v : 1
		
		//들어오면 본인 방문 설정
		isvisited[v] = true;
		st.append(v).append(" ");
		//recursive
		for (int i = 1; i <= N; i++) {
			if(arr[v][i] == 1 && !isvisited[i]) { // 서로 관계 있고 + 방문 안했을 때 출력
				dfs(i);
			}
		}
	}//dfs

	static void bfs(int v) {
		
		q.add(v);
		isvisited[v] = true;  // 시작값넣기
		
		while(!q.isEmpty()) {
			
			v = q.poll();
			st.append(v).append(" ");
			
			// 2차원 배열에서 행 고정 (이 자체로 정렬) >> 1~n까지 열 값 넣기(가로로)
			for (int i = 1; i <= N; i++) {
				if(arr[v][i] == 1 && !isvisited[i]) {
					q.add(i);			
					isvisited[i] = true;
				}
			}
		}
		q.clear();
	}


}