package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_조성환 {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static boolean[] isVisited;
	static boolean test;

	public static void dfs(int x, int cnt) {
		if (test == true) {
			return;
		}
		if (cnt == 4) {
			System.out.println(1);
			test = true;
			return;
		}

		isVisited[x] = true;
		for (int i = 0; i < arr[x].size(); i++) {
			int temp = arr[x].get(i);
			if (isVisited[temp] == false) {
				isVisited[temp] = true;
				dfs(temp, cnt + 1);
				isVisited[temp] = false;
			}
		}
		isVisited[x] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			arr[i] = new ArrayList<>();
		isVisited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		test = false;
		for (int i = 0; i < N; i++) {
			if (test == false) {
				dfs(i, 0);
			}
		}
		if (test != true) {
			System.out.println(0);
		}
	}
}
