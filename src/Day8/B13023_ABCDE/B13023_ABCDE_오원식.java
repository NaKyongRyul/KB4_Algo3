package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B13023_ABCDE_오원식 {

	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	static int check;
	static int res;

	public static void addEdge(int u, int v) {
		graph[u].add(v);
	}

	public static void DFS(int i, int check) {
		if (check == 4) {
			res = 1;
			return;
		}

		for (int j : graph[i])
			if (!isVisited[j]) {
				isVisited[j] = true;
				DFS(j, check + 1);
				isVisited[j] = false;
			}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		graph = new ArrayList[N];
		isVisited = new boolean[N];

		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);

			addEdge(u, v);
			addEdge(v, u);
		}

		for (int i = 0; i < N; i++) {
			if(res == 1) break;
			isVisited[i] = true;
			DFS(i, 0);
			isVisited[i] = false;
		}

		System.out.println(res);

	}

}

//6시5분 선릉 탑승
//6시20분 사당 하차
//6시30분 사당 탑승
//7시30분 신천 하차
//7시40분 도착
