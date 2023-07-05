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
	public String toString() { // 값을 출력하기 위한 toString : 이게 없으면 출력이 좌표값으로 나옴
		return "[" + this.start + ", " + this.end + ", " + this.weight + "]";
	}
}

public class B1197_최소스패닝트리_박찬욱 {

	static int v; // 정점의 개수 (1 ≤ V ≤ 10,000)
	static int e; // 간선의 개수 (1 ≤ E ≤ 100,000)
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
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(token.nextToken());
		e = Integer.parseInt(token.nextToken());
		
		int ans = 0; // 출력 : 최소 스패닝 트리의 가중치,  -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.
		parent = new int [v+1];
		Arrays.setAll(parent, i -> i); // setAll()은 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받는다.
		
		Edge [] edges = new Edge [e];
		
		for(int i = 0; i < e; i++) {
			token = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(token.nextToken()); //  A번 정점
			int v = Integer.parseInt(token.nextToken()); //  B번 정점
			int weight = Integer.parseInt(token.nextToken()); // 가중치 C인 간선, C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
			edges[i] = new Edge(u, v, weight);
		}
		
		//System.out.println(Arrays.toString(edges)); // 입력값 확인용
		
		// 간선 정렬
		Arrays.sort(edges, (a, b) -> a.weight - b.weight); // 오름 차순 정렬, a와 b의 자리를 바꾸면 내림차순 정렬 
		
		//System.out.println(Arrays.toString(edges)); // 정렬된 것 확인용
		
		// 구현
		for(int i = 0; i < e; i++) {
			if(find(edges[i].start) == find(edges[i].end)) continue;
			union(edges[i].start, edges[i].end);
			ans += edges[i].weight;
		}		
		
		System.out.println(ans);
	}
}