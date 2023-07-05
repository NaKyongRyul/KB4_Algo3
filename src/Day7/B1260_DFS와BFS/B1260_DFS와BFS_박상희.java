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

public class B1260_DFS와BFS_박상희 {
	static int N; // 정점의 개수
	static ArrayList<Integer> graph[];
	
	static void DFS(int node) {
		Stack<Integer> stack = new Stack<>();
		boolean isDFSVisited[] = new boolean[N + 1];
		
		stack.push(node);
		while (!stack.isEmpty()) {
			int nowNode = stack.pop();
			
			if (isDFSVisited[nowNode] == false) {
				System.out.print(nowNode + " ");
				isDFSVisited[nowNode] = true;
			}
			
			for (int nextNode : graph[nowNode]) {
				if (isDFSVisited[nextNode] == true) {
					continue;
				}
				
				stack.add(nextNode);
			}
		}
	}
	
	static void BFS(int node) {
		Queue<Integer> que = new ArrayDeque<>();
		boolean isVisited[] = new boolean[N + 1];
		
		que.add(node);
		isVisited[node] = true;
		while (!que.isEmpty()) {
			int nowNode = que.poll();
			System.out.print(nowNode + " ");
			
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
		int V = Integer.parseInt(token.nextToken()); // 탐색을 시작할 정점의 번호
		
		graph = new ArrayList[N + 1]; // padding을 위해 크기 N + 1로 설정
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int firstNode = Integer.parseInt(token.nextToken());
			int secondNode = Integer.parseInt(token.nextToken());

			graph[firstNode].add(secondNode);
			graph[secondNode].add(firstNode); // 양방향
		}
		
		for (int s = 0; s < N + 1; s++) { // 내림차순 정렬  // Stack을 사용해서 DFS를 구현하기 위해 내림차순 정렬 필요
			Collections.sort(graph[s], Collections.reverseOrder());
		}
		DFS(V);
		System.out.println();
		
		for (int s = 0; s < N + 1; s++) { // 오름차순 정렬
			Collections.sort(graph[s]);
		}
		BFS(V);
	}
}
