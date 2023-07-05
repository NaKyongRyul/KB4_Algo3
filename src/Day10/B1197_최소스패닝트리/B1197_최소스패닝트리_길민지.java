package Day10.B1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1197_최소스패닝트리_길민지 {
	static int V, E;
	static int parent[];
	static Edge edges[];
	static int weight;
	
	static class Edge{
		int u, v, c;
		Edge(int u, int v, int c){
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}
	
	// 같은 그룹인 지 확인
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	// 같은 그룹으로 합치기
	static void union(int x, int y) {
		x = parent[x];
		y = parent[y];
		
		if (x>y) parent[x] = y;
		else parent[y] = x;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V+1];
		edges = new Edge[E];
		
	  // 부모 배열 초기화
		for (int i=1; i<V+1; i++) parent[i] = i;
		
		// 간선 정보 입력
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u, v, c);
		}
		
		// 가중치 오름차순 정렬
		Arrays.sort(edges, (o1, o2) -> (o1.c - o2.c));
		
		// 크루스칼 알고리즘
		for (int i=0; i<E; i++) {
			Edge now = edges[i];
			if (find(now.u) == find(now.v)) continue;
			weight += now.c;
			union (now.u, now.v);
		}

		// 출력
		System.out.println(weight);
	}

}