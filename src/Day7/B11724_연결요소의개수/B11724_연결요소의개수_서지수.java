package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_서지수 {
	static boolean[] isVisited;
	static int N;
	static int M;
	static ArrayList<Integer>[] arr;
	static int cnt = 0;
	
	static ArrayList<Integer>[] result;

	static void dfs(int V) {
		// 재귀
		// System.out.print(V + " ");
		isVisited[V] = true;
		for (int i : arr[V]) {
			if (!isVisited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		result = new ArrayList[N + N];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);

		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(arr[i]);
		}

		isVisited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (isVisited[i] == false) {
				dfs(i);
				cnt += 1;
			}

		}
		System.out.println(cnt);
	}
}
