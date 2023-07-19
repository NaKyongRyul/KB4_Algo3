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

public class B1260_DFS와BFS_김현지 {
	
	static int N;
	static int M;
	static int V;
	
	static ArrayList <Integer>[] tree;
	static boolean [] visited;
	
	
	public static void DFS(int nowNode) {
		// 2차원 배열 정렬: Collection은 1차원 배열밖에 정렬할 수 없으므로
		for (int i=0; i<N+1; i++) {
			Collections.sort(tree[i], Collections.reverseOrder());
		}
//		// tree에 입력이 제대로 되어있는지 확인
//		for(int i=0; i<N+1; i++) {
//			System.out.println(tree[i]);
//		}
		// 공동으로 사용하지 않도록 초기화
		visited = new boolean[N+1];
		// 스택 초기화
		Stack <Integer> stack = new Stack<>();		
		// 스택에 첫 원소 추가
		stack.add(nowNode);
//		visited[nowNode] = true;
		
		int node;
		while (!stack.isEmpty()) {
//			System.out.println("stack:" + stack);
			node = stack.pop();
			// 마킹 로직을 앞으로 빼줌, 이때 첫번째 요소도 방문처리 x
			if (visited[node] ) {
				continue;
			}
			visited[node] = true;
			System.out.print(node + " ");
			for (int nextNode:  tree[node]) {
//				if (visited[nextNode]) {
//					continue;
//				}
//				visited[nextNode] = true;
				stack.add(nextNode);
			}
		}
	}

	public static void BFS(int nowNode) {
		// 2차원 배열 정렬: Collection은 1차원 배열밖에 정렬할 수 없으므로
		for (int i=0; i<N+1; i++) {
			Collections.sort(tree[i]);
		}

		visited = new boolean[N+1];
		// 큐 초기화
		Queue <Integer> que = new ArrayDeque<>();
		que.add(nowNode);
		visited[nowNode] = true;
		
		int node;
		while (!que.isEmpty()) {
//			System.out.println("que:" + que);
			node = que.poll();
			System.out.print(node + " ");
			for (int nextNode:  tree[node]) {
				if (visited[nextNode]) {
					continue;
				}
				visited[nextNode] = true;
				que.add(nextNode);
			}
		}
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		
		// 트리 초기화
		tree = new ArrayList [N+1];
		visited = new boolean [N+1];

		for (int i=0; i<N+1; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		// 간선 연결
		int fromNode;
		int toNode;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			fromNode = Integer.parseInt(st.nextToken());
			toNode = Integer.parseInt(st.nextToken());
			tree[fromNode].add(toNode);
			tree[toNode].add(fromNode);
		}
		

//		// 2차원 배열 정렬: Collection은 1차원 배열밖에 정렬할 수 없으므로
//		for (int i=0; i<N+1; i++) {
//			Collections.sort(tree[i], Collections.reverseOrder());
//		}

//		// tree에 입력이 제대로 되어있는지 확인
//		for(int i=0; i<N+1; i++) {
//			System.out.println(tree[i]);
//		}
		
		DFS(V);
		System.out.println();
		BFS(V);

	}

}
