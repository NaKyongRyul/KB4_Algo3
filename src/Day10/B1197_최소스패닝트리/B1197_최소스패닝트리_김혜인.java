
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

	int start;
	int end;
	int weight;
	public Object u;

	public Edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	// 간선의 크기로 오름차순하기 위한 compareTo()메서드
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}

public class B1197_최소스패닝트리_김혜인 {
	static int V; // 정점의 개수
	static int E; // 간선의 개수
	static int[] parent; // 부모노드 배열 저장
	static List<Edge> list = new ArrayList();

	public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
    int V = Integer.parseInt(token.nextToken());
    int E = Integer.parseInt(token.nextToken());
    int ans = 0;
    
    parent = new int [V+1];
    for (int i = 0; i < parent.length; i++) { //부모노드 세팅
		parent[i] = i;
	}; 
    
    for(int i=0; i<E; i++) {
        token = new StringTokenizer(bf.readLine() , " ");
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());
        int weight = Integer.parseInt(token.nextToken());
        list.add(new Edge(start,end,weight));
    }
    
    	// 오름차순 정렬
 		Collections.sort(list);
 		
 		int size = list.size();
 		// 2. 정렬된 순서대로 간선 탐색
 		for (int i = 0; i < size; i++) {
 			Edge n = list.get(i);
 			// 만약 두 노드의 부모가 다르다면
 			if(!isSameParent(n.start, n.end)) {
 				// sum에 간선 크기 저장
 				ans +=n.weight;
 				// 두 노드 연결
 				union(n.start,n.end);
 			}
 			
 		}
 	
 		System.out.println(ans);
   
}
	
	
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
		// 부모가 같은지를 판별해주는 method
		private static boolean isSameParent(int a, int b) {
			a = find(a);
			b = find(b);

			if (a == b)
				return true;
			else
				return false;
		}
}
