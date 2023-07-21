package Day10.B1197_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class EdgeInfo{ // 간선
	int u;
	int v;
	int weight;
	
	EdgeInfo(int u, int v, int weight){
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
}

public class B1197_최소신장트리_강윤서 {
	static int[] parent;
	static int totalWeight = 0; // 최소 스패닝 트리 가중치
	
	public static int find(int x) { // FIND 작업
		if (x==parent[x])
			return x;
		return parent[x] = find(parent[x]);	
	}
	
	public static void union(int x, int y) { // UNION 작업
		x = find(x);
		y = find(y);
		if (x!=y) {
			if (x<y) { // 작은 숫자를 부모로 설정
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 정점 개수
		int e = Integer.parseInt(st.nextToken()); // 간선 개수
		
		// 간선 정보
		EdgeInfo[] edgeList = new EdgeInfo[e];
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new EdgeInfo(a, b, weight);			
		}
		
		// 간선 가중치로 오름차순 정렬
		Arrays.sort(edgeList, (a, b)->a.weight-b.weight);
		
		// 부모 정보 자기자신으로 초기화
		parent = new int[v+1];
		Arrays.setAll(parent, (i)->i); // 인덱스로 초기화
		
		// 최소 스패닝 트리 가중치 계산
		for (int i=0; i<e; i++) {
			EdgeInfo nowEdge = edgeList[i];
			if (find(nowEdge.u)!=find(nowEdge.v)) { // 같은 집합 여부 확인
				union(nowEdge.u, nowEdge.v);
				totalWeight+=nowEdge.weight;
			}
		}
		System.out.println(totalWeight);
	}
}
