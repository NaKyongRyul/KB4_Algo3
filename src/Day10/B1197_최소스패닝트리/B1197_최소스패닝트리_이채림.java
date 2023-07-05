package Day10.B1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {

	int start;
	int end;
	int weight;

	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "[" + this.start + "," + this.end + "," + this.weight + "]";
	}

}

public class B1197_최소스패닝트리_이채림 {

	static int[] parent;

// x의 부모를 찾는 연산
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
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());

		int ans = 0;
		parent = new int[V + 1];
		Arrays.setAll(parent, i -> i);

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			edges[i] = new Edge(u, v, weight);
		}

		// 간선 정렬 //
		Arrays.sort(edges, (a, b) -> a.weight - b.weight);

		// 구현 //
		int sum = 0;
		for (int i = 0; i < E; i++) {
			if (find(edges[i].start) == find(edges[i].end))
				continue;
			union(edges[i].start, edges[i].end);
			sum += edges[i].weight;
		}

		System.out.println(sum);

		//////////

	}
}