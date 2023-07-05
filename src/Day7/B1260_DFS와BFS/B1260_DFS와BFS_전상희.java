package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1260_DFS와BFS {
	static boolean[] isVisited;
	static ArrayList<Integer>[] graph;

	static void DFS(int startV) {
		isVisited[startV] = true;
		System.out.print(startV + " ");
		
		for(int nextNode : graph[startV]) {
			if(isVisited[nextNode]) continue;
			DFS(nextNode); // 재귀
		}
		
	}
	
	static void BFS(int startV) {
		Queue <Integer> que = new ArrayDeque<>();
		que.add(startV);
		isVisited[startV] = true;
		while(!que.isEmpty()) {
			int nowNode = que.poll(); // 큐에서 노드를 꺼낸 뒤
			
			System.out.print(nowNode + " ");
			
			for(int nextNode : graph[nowNode]) {
				if(isVisited[nextNode]) continue;
				isVisited[nextNode] = true;
				que.add(nextNode); // 꺼낸 노드의 인접 노드를 큐에 삽입한다
			} // 연결된 노드들을 따라가면서 하나씩 넣고 꺼내고 출력하길 반복
		}
	}
	
	static void stackDFS(int startV) { // stack ver
		Stack <Integer> stack = new Stack<>();
		stack.push(startV);
		
		while(!stack.isEmpty()) {
			int now = stack.pop();
			
			if(isVisited[now] == false) {
				isVisited[now] = true;
				System.out.print(now + " ");
			}
			
			for(int nextNode : graph[now]) {
				if(isVisited[nextNode]) continue;
				stack.add(nextNode);
			}
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(token.nextToken()); // 정점의 개수
		int M = Integer.parseInt(token.nextToken()); // 간선의 개수(양방향)
		int V = Integer.parseInt(token.nextToken()); // 탐색 시작할 정점의 번호
		
		isVisited = new boolean[N+1];
		graph = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {		
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<M ; i++) {
			token = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			
			graph[u].add(v);
			graph[v].add(u); // 양쪽 노드에 서로를 추가
		}
		for(int i=0; i<N+1; i++) {
			Collections.sort(graph[i]); // 정렬 안 하면 안 돌아감 !!
			//System.out.println(graph[i]);
		}
		
		DFS(V);
		System.out.println();
		isVisited = new boolean[N+1]; // 초기화
		BFS(V);
		System.out.println();
		isVisited = new boolean[N+1]; // 초기화
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
			//System.out.println(graph[i]);
		} // 내림차순 정렬해야 돌아간다 
		
		stackDFS(V);
	}
}
