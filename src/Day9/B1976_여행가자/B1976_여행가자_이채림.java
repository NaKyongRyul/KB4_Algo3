package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_이채림 {

	static int parent[];
	static int N;
	static int M;
	static int rel[][];
	static int arr[];

	static int find(int x) {
		if (x == parent[x])
			return x;

		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y)
				parent[y] = x; // 더 작은값을 부모 노드로 넣어줌
			else
				parent[x] = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());// <= 200
		M = Integer.parseInt(bf.readLine());// 왜 너는 bf.readLine()이니 ?

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		arr = new int[M];
		rel = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < N + 1; j++) {
				rel[i][j] = Integer.parseInt(st.nextToken());
				if (rel[i][j] == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < M - 1; i++) {
			if (parent[arr[i]] == parent[arr[i + 1]])
				cnt++;
		}
		if (cnt == M - 1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
