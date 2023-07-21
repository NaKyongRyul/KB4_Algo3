package Day10.B1197_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
}

public class B1197_최소신장트리_김현지 {
	static int [] parent;
	
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int [V+1];
		Arrays.setAll(parent, i->i);
		Edge [] edgeArr = new Edge[E];
		
		// A정점, B정점, 두 vertex를 연결하는 가중치
		int A; int B; int weight;
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
//			System.out.println("A: " + A + ", B: " + B + ", weight: " + weight);
			edgeArr[i] = new Edge(A, B, weight);
		}
		
		// 1. 그래프의 간선들을 가중치의 오름차순으로 정렬
		Arrays.sort(edgeArr, (a,b) -> a.weight - b.weight);

		int rootA; int rootB; int weightAB;
		int totalWeight = 0;
		for (int i=0; i<E; i++) {
			A = edgeArr[i].u;
			B = edgeArr[i].v;
			rootA = find(A);
			rootB = find(B);
			weightAB = edgeArr[i].weight;
//			System.out.println("rootA: " + rootA + "rootB: " + rootB + "weightAB: " + weightAB);
			
			// 2. 정렬된 간선 중 순서대로 사이클을 형성하지 않는 간선 선택(유니온 파인드)
			if (rootA != rootB) {
//				System.out.println("rootA: " + rootA + "rootB: " + rootB);
				union(A, B);
				// 3. 해당 간선을 MST 집합에 추가
//				System.out.println("totalWeight: " + totalWeight);
				totalWeight += weightAB;
			}
		}
		System.out.println(totalWeight);

	}

}
