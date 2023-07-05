package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_길민지 {
	static int N, M;
	static ArrayList<Integer> graph [];
	static boolean isVisited[];
	static int cnt;
	static boolean flag;
	
	static void search(int node) {
		if (isVisited[node]) { // 이미 방문한 node라면 종료
			return;
		}
		if (!flag) { // 그룹의 첫번째 요소라면 cnt늘리고 체크
			flag = true;
			cnt++;
		}
		
		isVisited[node] = true;
		
		for (int i : graph[node]) {
			if (isVisited[i]) continue;
			search(i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) graph[i] = new ArrayList<>();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		isVisited = new boolean[N+1];
		
		// 모든 점에 대하여 탐색
		for (int i=1; i<N+1; i++) {
			search(i);
			flag = false;
		}
		System.out.println(cnt);
	}

}
