package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_이채림 {

	static int N;
	static int M; 
	static ArrayList<Integer> graph[];
	static boolean isVisited[];
	static int result = 0;

	static void dfs(int nowNode, int cnt) {
		if (cnt == 4) {
			result = 1;
			return;
		}

		for (int nextNode : graph[nowNode]) {
			if (isVisited[nextNode])
				continue;
			isVisited[nextNode] = true;
			dfs(nextNode, cnt + 1);
			isVisited[nextNode] = false;	
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N];
		isVisited = new boolean[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			isVisited[i] = true;
			dfs(i, 0);
			if (result == 1)
				break;
		}

		System.out.println(result);
	}

}
