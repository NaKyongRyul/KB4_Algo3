package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_곽승규 {

	static boolean [] visited;
	static ArrayList<Integer>[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호
		
		A = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		//인접리스트 값 넣기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}
		
		// 정점이 여러 개 인 경우에는 정점 번호가 작은 것을 먼저방문
		for (int i= 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		//System.out.println(Arrays.deepToString(A));
		
		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		BFS(V);
	}
	
	static void DFS(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for (int i : A[start]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
		
	}

	static void BFS(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int i : A[now]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
				
			}
		}
	}
}
