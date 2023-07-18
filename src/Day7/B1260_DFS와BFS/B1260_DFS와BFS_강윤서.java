package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_강윤서 {
	static int n; // 정점 개수
	static int m; // 간선 개수
	static int startNode; // 시작 정점
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited; // 방문 여부-DFS와 BFS에서 모두 사용
	static Queue<Integer> queue = new ArrayDeque<>(); // BFS에서 사용
	
	public static void dfs(int nowNode) { // 깊이 우선 탐색-재귀
		System.out.print(nowNode+" ");
		isVisited[nowNode] = true; // 방문 처리
		for (int nextNode : graph[nowNode]) { // 연결된 노드 확인
			if (!isVisited[nextNode]) { // 아직 방문 처리 안했으면
				dfs(nextNode);
			}
		}
	}
	
	public static void bfs(int startNode) { // 너비 우선 탐색-큐
		queue.offer(startNode);
		System.out.print(startNode+" ");
		isVisited[startNode] = true; // 방문 처리
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int nextNode : graph[nowNode]) { // 연결된 노드 확인
				if (!isVisited[nextNode]) { // 아직 방문 처리 안했으면
					queue.offer(nextNode);
					System.out.print(nextNode+" ");
					isVisited[nextNode] = true; // 방문 처리
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int startNode = Integer.parseInt(st.nextToken()); // 시작 정점
		
		// 그래프 구조
		graph = new ArrayList[n+1];
		for (int i=1; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			graph[one].add(two);
			graph[two].add(one);
		}
		
		// 오름차순 정렬
		for (int i=1; i<n+1; i++) {
			Collections.sort(graph[i]);
		}
		
		// DFS 수행
		isVisited = new boolean[n+1];		
		dfs(startNode);
		
		// BFS 수행
		isVisited = new boolean[n+1];
		System.out.println();
		bfs(startNode);
	}
}
