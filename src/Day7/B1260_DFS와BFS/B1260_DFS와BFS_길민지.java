package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_길민지 {
	static int N, M, V;
	static ArrayList <Integer> graph[];
	static boolean isVisited[];
	
	// 재귀 사용
	static void DFS(int v) {
		if (isVisited[v]==false) { // 방문하지 않았다면 출력하고 방문 처리
			System.out.print(v + " ");
			isVisited[v] = true;
		}
		for (int i=0; i<graph[v].size();i++) { // 인접 노드 탐색
			if (isVisited[graph[v].get(i)]==true) continue;
			DFS(graph[v].get(i));
		}
	}
	
	
	// 스택 사용
	/*
	static void DFS(int root) {
		Stack <Integer> stack = new Stack();
		
		stack.add(root); // 루트 노드 push
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			
			if (isVisited[node]==false) { // 방문하지 않았다면 출력하고 방문 처리
				System.out.print(node+" ");
				isVisited[node] = true;
			}
			
			for (int next : graph[node]) { // 인접 노드 탐색
				if (isVisited[next]==true) continue;
				stack.add(next); // push
			}
		}
	}
	*/
	
	static void BFS(int root) {
		Queue <Integer>que = new ArrayDeque<Integer>();
		
		que.add(root); // 루트 노드 Enqueue
		isVisited[root] = true;
		
		while (!que.isEmpty()) {
			int node = que.poll(); // Dequeue
			System.out.print(node+" ");
			
			for (int i=0; i<graph[node].size();i++) { // 인접 노드 탐색
				if (isVisited[graph[node].get(i)]==true) continue;
				que.add(graph[node].get(i)); // 인접 노드 Enqueue
				isVisited[graph[node].get(i)] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) graph[i] = new ArrayList <Integer>();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		// 정렬
		for (int i=0; i<N+1; i++) Collections.sort(graph[i]);
		
		// 스택 사용의 경우 내림차순 정렬
		// for (int i=0; i<N+1; i++) Collections.sort(graph[i], Collections.reverseOrder());
		
		isVisited = new boolean[N+1];
		DFS(V);
		System.out.println();
		
		// 다시 오름차순 정렬
		// for (int i=0; i<N+1; i++) Collections.sort(graph[i]);
		
		isVisited = new boolean[N+1];
		BFS(V);
	}

}
