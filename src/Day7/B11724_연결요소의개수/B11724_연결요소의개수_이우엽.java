package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_이우엽 {
	static List<Integer>[] tree;
	static boolean[] isVisited;
	public static void DFS(int node) {
		isVisited[node] = true;
		for(int adj : tree[node]) {
			if(isVisited[adj]) continue;
			isVisited[adj] = true;
			DFS(adj);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		// 정점의 수 N
		int N = Integer.parseInt(token.nextToken());
		// 간선의 수 M
		int M = Integer.parseInt(token.nextToken());
		// 인접리스트 tree 1 ~ N
		tree = new ArrayList[N+1];
		// 방문배열 1 ~ N
		isVisited = new boolean[N+1];
		
		// 각 배열의 요소에 ArrayList 세팅
		for(int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		// 간선의 개수만큼 양끝점 입력받고 인접리스트에 넣어주기
		for(int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		// 인접리스트 test 출력
		for(int i = 1; i < tree.length; i++) {
			Collections.sort(tree[i]); // 정렬 중요
		}
		
		// 정점의 개수만큼 DFS를 돌린다
		int cnt = 0;
		for(int i = 1; i < tree.length; i++) {
			if(isVisited[i]) continue;
			DFS(i);
			cnt++;
		}
		System.out.println(cnt);
	}
}

