package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_강윤서 {
	static ArrayList<Integer>[] graph;
	static int n; // 정점 개수
	static int m; // 간선 개수
	static boolean[] isVisited; // 방문 여부
	static int count = 0; // 연결 요소 개수
	
	public static void dfs(int nowNode) { // 깊이 우선 탐색-재귀
		isVisited[nowNode] = true; // 방문 처리
		
		for(int nextNode : graph[nowNode]) { // 연결된 노드 확인
			if (!isVisited[nextNode]) { // 아직 방문 처리 안했으면
				dfs(nextNode);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 정점 개수
		m = Integer.parseInt(st.nextToken()); // 간선 개수
		
		// 그래프 구조
		graph = new ArrayList[n+1];
		for (int i=1; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}	
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		isVisited = new boolean[n+1];
		for (int i=1; i<n+1; i++) {
			if (!isVisited[i]) { // 아직 방문 처리 안했으면 연결된 노드 확인을 위해 dfs 수행
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
}
