package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class B1260_DFS와BFS_오원식 {

	static int N;
	static int M;
	static int V;
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	static int node;

	public static void addEdge(int u, int v) {
		graph[u].add(v);
	}

//	public static void DFS(int nowNum) {
//		isVisited[nowNum] = true;
//		System.out.print(nowNum + " ");
//		for (int i : graph[nowNum]) {
//			if (isVisited[i] == false)
//				DFS(i);
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		V = Integer.parseInt(s[2]);

		graph = new ArrayList[N + 1];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);

			addEdge(u, v);
			addEdge(v, u);
		}

		for (int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}

//		isVisited = new boolean[N + 1];
//		DFS(V);

		for (int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		Stack<Integer> stack = new Stack<>();
		isVisited = new boolean[N + 1];
		stack.push(V);

		while (!stack.isEmpty()) {
			node = stack.pop();
			if (isVisited[node] == true)
				continue;

			isVisited[node] = true;
			System.out.print(node + " ");

			for (int i : graph[node])
				stack.push(i);

		}

		System.out.println();
		
		for (int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}

		Queue<Integer> que = new ArrayDeque<>();
		isVisited = new boolean[N + 1];
		isVisited[V] = true;
		que.offer(V);

		while (!que.isEmpty()) {
			node = que.poll();
			System.out.print(node + " ");

			for (int i : graph[node]) {
				if (isVisited[i] == false) {
					isVisited[i] = true;
					que.offer(i);
				}
			}
		}

	}

}
