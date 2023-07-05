package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_이채림 {

	static int parent[];
	static int N;
	static int M;
	static int arr[][];

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	// y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;// 아직 연결되지 않았으므로 각각의 부모노드는 자신이다.
		}

		arr = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int op = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (op == 0)
				union(u, v);
			else {
				if(find(u) == find(v)) System.out.println("YES");
				else System.out.println("NO");
			}
		}

	}
}
