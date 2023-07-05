package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_박상희 {
	static int N; // 정점의 개수
	static ArrayList<Integer> graph[];
	static boolean isVisited[];
	static int count = 0;
	
	static void BFS(int node) { // BFS 탐색
		Queue<Integer> que = new ArrayDeque<>();
		
		que.add(node);
		isVisited[node] = true;
		while (!que.isEmpty()) {			
			int nowNode = que.poll();
			
			for (int nextNode : graph[nowNode]) {
				if (isVisited[nextNode] == false) {
					que.add(nextNode);
					isVisited[nextNode] = true;
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
		int M = Integer.parseInt(token.nextToken()); // 간선의 개수
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		isVisited = new boolean[N + 1];
		for (int j = 1; j <= N; j++) { // 전체 노드 BFS 탐색을 위해 노드 수만큼 반복
			if (!isVisited[j]) { // 해당 노드를 반복하지 않았다면
				BFS(j); // BFS 탐색
				count++;
			}
		}
		
		System.out.println(count);
	}
}
