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
		return "[" + this.start + ", " + this.end + ", " + this.weight + "]";
	}
}

public class B1197_최소스패닝트리_곽승규 {

	static int [] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		parent = new int[V+1];
		Arrays.setAll(parent, i->i);
		//System.out.println(Arrays.toString(parent));
		
		Edge [] edges = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u, v, weight);
		}
		
		
		// 간선 정렬 //
		Arrays.sort(edges, (a,b)-> a.weight - b.weight);
		//System.out.println(Arrays.toString(edges));
		
		
		// 구현
		int useEgde = 0;
		int i = 0;
		int result = 0;
		while ( useEgde < V - 1) {
			Edge nowEdge = edges[i];
			
			if (find(nowEdge.start) != find(nowEdge.end)) {
				union(nowEdge.start, nowEdge.end);
				result += nowEdge.weight;
				useEgde++;
				
			}
			i++;
		}
		
		System.out.println(result);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
		}
	}
	
	static int find(int a) {
		if ( a == parent[a] ) {
			return a;
		}else {
			return parent[a] = find(parent[a]);
		}
		
	}
}
