package Day9.B1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1325_효율적인해킹_이채림 {

	static int N;
	static int M;
	static ArrayList<Integer> graph[];
	static int cnt[];
	static int max = 0;
	static boolean isVisited[];

	static void dfs(int num) {
		isVisited[num] = true;
		for (int next : graph[num]) {
			if (isVisited[next])
				continue;
			cnt[next]++;
			dfs(next);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		cnt = new int[N + 1];// 연결되어있을 때마다 카운트 올려줄거임
		isVisited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
		}

		for (int i = 1; i < N + 1; i++) {
			isVisited = new boolean[N + 1];
			
			dfs(i);
		}

		for (int i = 1; i < N + 1; i++) {
			if (max < cnt[i])
				max = cnt[i];
		}

		for (int i = 1; i < N + 1; i++) {
			if (cnt[i] == max)
				System.out.print(i + " ");
		}
	}
}
