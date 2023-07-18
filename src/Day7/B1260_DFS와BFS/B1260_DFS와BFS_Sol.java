package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_Sol {

	static int N;
	static int M;
	static int V;
	static ArrayList <Integer> [] graph;
	static boolean [] isVisited;

	// 재귀로 DFS 구현하기 //
	public static void RecursiveDFS(int start) {
		System.out.print(start + " ");
		for(int nextNode : graph[start]) {
			// 중복인 경우
			if(isVisited[nextNode]) continue;
			isVisited[nextNode] = true;
			RecursiveDFS(nextNode);
		}
	}


	// 스택을 이용해 DFS 구현하기 //
	public static void IterativeDFS(int start) {
		Stack <Integer> stack = new Stack<>();
		stack.add(start);

		isVisited = new boolean [N+1];

		// 큐를 반복문
		while(!stack.isEmpty()) {

			// 현재 탐색 노드
			int nowNode = stack.pop();

			// nowNode 에 대해서 중복 확인 및 마킹
			if(isVisited[nowNode] == true) continue;
			isVisited[nowNode] = true;

			System.out.print(nowNode + " ");

			// 재귀 확장
			for(int nextNode : graph[nowNode]) {
				stack.add(nextNode);
			}
		}
	}

	// 큐를 이용해 BFS 구현하기 //
	public static void BFS(int start) {

		Queue <Integer> que = new LinkedList<>();
		que.add(start);

		isVisited = new boolean [N+1];
		isVisited[start] = true;

		// 큐를 반복문
		while(!que.isEmpty()) {

			// 현재 노드
			int nowNode = que.poll();
			System.out.print(nowNode + " ");

			// 다음 노드 확장
			for(int nextNode : graph[nowNode]) {

				// 중복 체크 및 마킹
				if(isVisited[nextNode] == true) continue;
				isVisited[nextNode] = true;

				// 다음 노드 인큐
				que.add(nextNode);
			}
		}
	}



	public static void main(String[] args) throws IOException {

		// 입력 처리 //
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		V = Integer.parseInt(token.nextToken());

		// 인접리스트 초기화 //
		graph = new ArrayList [N+1];
		for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

		// 마킹 배열 초기화 //
		isVisited = new boolean [N+1];

		// 인접리스트 업데이트 //
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(io.readLine() , " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			graph[u].add(v);
			graph[v] .add(u);
		}

		// 인접리스트 전부 다 오름차순 정렬
		for(int i=0; i<N; i++) {
			Collections.sort(graph[i]);
		}

		// 재귀  DFS
		isVisited[V] = true;
		RecursiveDFS(V);

		// BFS
		System.out.println();
		BFS(V);

		// 스택 DFS (확인하려면 주석 해제)
		// 인접리스트 전부 다 내림차순 정렬 (재귀 DFS 와 반대)
		for(int i=0; i<N; i++) {
			Collections.sort(graph[i] , Collections.reverseOrder());
		}
//		System.out.println();
//		IterativeDFS(V);

	}
}