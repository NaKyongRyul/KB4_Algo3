package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11724_연결요소의개수_오원식 {

	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	static int res;

	public static void addEdge(int u, int v) {
		graph[u].add(v);
	}

	public static void DFS(int nowNum) {
		isVisited[nowNum] = true;

		for (int i : graph[nowNum]) {
			if (isVisited[i] == false) {
				DFS(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		graph = new ArrayList[N + 1];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);

			addEdge(u, v);
			addEdge(v, u);
		}

		isVisited = new boolean[N + 1];

		for (int i = 1; i < graph.length; i++) {
			if (isVisited[i])
				continue;
			DFS(i);
			res++;
		}

		System.out.println(res);
	}

}
