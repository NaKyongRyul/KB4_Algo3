package Day10.B1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자: 이지은
 * 문제: 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.
 *      최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
 * 
 * 순서 
 * 1. 그래프의 간선들을 가중치 오름차순으로 정렬
 * 2. 정렬된 간선 중 순서대로 사이클을 형성하지 않는 간선 선택(유니온파인드)
 * 3. 해당 간선을 MST집합이 추가
 */

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
			return "[" +  start  + ", " + end + ", " + weight + "]";
		}
}

public class B1197_최소스패닝트리_이지은 {
	static int [] parent;
	
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());  //정점의 개수 
		int E = Integer.parseInt(st.nextToken());  //간선의 개수 
		int ans = 0;
		
		parent = new int[V+1];
		Arrays.setAll(parent, i->i); //초기화 
		
		Edge []  edges = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			//가중치 넣어줌 
			edges[i] = new Edge(u, v, weight);
		}
		
//		System.out.println(Arrays.toString(edges));
		
		//부모 초기화 
		for(int i =0; i<V+1; i++) {
			parent[i] = i;
		}
		
		//간선 정렬  -> 가중치를 기준으로 정렬 
		Arrays.sort(edges, (a,b) ->  a.weight - b.weight);
		
		//구현 
		for(Edge e: edges) {
			if(find(e.start) != find(e.end)) {
				union(e.start, e.end);
				ans += e.weight;
			}
		}
		
		System.out.println(ans);
	}
}
