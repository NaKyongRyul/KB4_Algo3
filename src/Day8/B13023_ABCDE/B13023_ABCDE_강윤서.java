package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_강윤서 {
	static int n; // 사람 수
	static int m; // 친구 관계 수
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited; // 방문 여부
	static int result = 0; // 결과
	
	public static void dfs(int nowNode, int size) { // 깊이 우선 탐색-재귀
		if (result==1) return; // 5명이 친구인지 확인했으면
		
		isVisited[nowNode] = true; // 방문 처리
		size++;
		
		// 종료 조건
		if (size >= 5) { // 5명 이상 선택한 경우
			result = 1;
			return;
		}

		for (int nextNode : graph[nowNode]) { // 연결된 노드 확인
			if (!isVisited[nextNode]) { // 아직 방문 처리 안했으면
				dfs(nextNode, size); // 조합 생성
				isVisited[nextNode] = false; // 다음 조합을 만들기 위해 초기화
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 사람 수
		m = Integer.parseInt(st.nextToken()); // 친구 관계 수
		
		// 그래프 구조
		graph = new ArrayList[n];
		for (int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);			
		}
		
		// 각 노드를 기준으로 dfs수행 시 5명이 친구인지(depth=5번)
		for (int i=0; i<n; i++) {
			isVisited = new boolean[n]; // 초기화
			if (result==1) break; // 5명이 친구인지 확인했으면
			else dfs(i, 0);
		}
		System.out.println(result);
	}
}
