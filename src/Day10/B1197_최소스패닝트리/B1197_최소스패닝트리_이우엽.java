package Day10.B1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge {
	int u;
	int v;
	int weight;
	Edge(int u, int v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return u + " " + v + " " + weight;
	}
}
public class B1197_최소스패닝트리_이우엽 {
	static int[] parent;
	public static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		Edge[] edges = new Edge[E];
		parent = new int[V+1];
		Arrays.setAll(parent, (i) -> (i));
		
		for(int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			edges[i] = new Edge(u, v, weight);
		}
//		System.out.println(Arrays.toString(edges));
		
		Arrays.sort(edges, new Comparator<Edge>(){
			@Override
			public int compare(Edge a, Edge b) {
				return a.weight - b.weight;
			}
		});
		
		int sum = 0;
		for(int i = 0; i < edges.length; i++) {
			Edge cur = edges[i];
			// 루트가 같으면 이미 연결
			if(find(cur.u) == find(cur.v)) continue;
			union(cur.u, cur.v);
			sum += cur.weight;
		}
		
//		System.out.println(Arrays.toString(parent));
		System.out.println(sum);

	}
}
