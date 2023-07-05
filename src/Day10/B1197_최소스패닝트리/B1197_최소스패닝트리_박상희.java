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

public class B1197_최소스패닝트리_박상희 {
	static int V;
	static int E;
	static int parent[];
	static Edge edges[];
	static int answer = 0;
	
	// y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } 
            else {
                parent[x] = y;
            }
        }
    }
    
	// x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    // 최소 스패닝 트리의 가중치를 찾는 함수
    public static void findMST() {    	
    	for (int f = 0; f < E; f++) {
    		if (find(edges[f].start) != find(edges[f].end)) {
    			union(edges[f].start, edges[f].end);
    			answer += edges[f].weight;
    		}
    	}
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		V = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		
		parent = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parent[i] = i;
		}
		
		edges = new Edge [E];
		
		for (int e = 0; e < E; e++) {
			token = new StringTokenizer(bf.readLine());
			
			int start_edge = Integer.parseInt(token.nextToken());
			int end_edge = Integer.parseInt(token.nextToken());
			int edge_weight = Integer.parseInt(token.nextToken());
			
			edges[e] = new Edge(start_edge, end_edge, edge_weight);
		}
				
		Arrays.sort(edges, (a, b) -> a.weight - b.weight); // 가중치 기준으로 간선 오름차순 정렬
		
		findMST(); // 정렬 후 찾기 때문에 가중치 최솟값을 찾을 수 있다.
		System.out.println(answer);
	}
}
