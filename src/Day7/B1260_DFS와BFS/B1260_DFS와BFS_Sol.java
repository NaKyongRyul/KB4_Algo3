package Day7.B1260_DFS와BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_Sol {

	static int N;
	static int M;
	static int V;
	static ArrayList <Integer> [] graph;
	static boolean [] isVisited;
	
	public static void searchDFS(int start) {
		System.out.print(start + " ");
		for(int nextNode : graph[start]) {
			if(isVisited[nextNode]) continue;
			isVisited[nextNode] = true;
			searchDFS(nextNode);
		}
	}
	
	public static void searchBFS(int start) {
		Queue <Integer> que = new LinkedList<>();
		que.add(start);
		isVisited[start] = true;
		while(!que.isEmpty()) {
			int nowNode = que.poll();	// 현재노드 꺼냄
			System.out.print(nowNode + " ");	
			for(int nextNode : graph[nowNode]) {
				if(isVisited[nextNode] == true) continue;	// 중복이면 skip
				isVisited[nextNode] = true;			// 탐색하면 중복마킹
				que.add(nextNode);					// 큐에 
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		V = Integer.parseInt(token.nextToken());
		
		graph = new ArrayList [N+1];
		for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(io.readLine() , " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			graph[u].add(v);
			graph[v] .add(u);
		}
		
//		for(int i=0; i<N+1; i++)  System.out.println(graph[i]);
		for(int i=0; i<N+1; i++) Collections.sort(graph[i]);
		
		isVisited = new boolean [N+1];
		isVisited[V] = true;
		searchDFS(V);
		
		System.out.println();
		
		isVisited = new boolean [N+1];
		isVisited[V] = true;
		searchBFS(V);
		
		
	}
}
